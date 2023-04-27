package com.wjh.www.util;

import com.wjh.www.util.constant.Constants;

import java.io.InputStream;
import java.sql.*;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

/**
 * @author wjh
 */
public class ConnectionPool {
    /*
    连接池中连接的初始数量
     */
    private int initialConnections = Constants.POOL_INIT_SIZE;
    /*
    连接池连接数量不够时在，自动创建的连接数
     */
    private int incrementalConnections = Constants.POOL_INCREMENTAL_SIZE;
    /*
    该连接池的最大连接数
     */
    private int maxConnections = Constants.POOL_MAX_SIZE;
    /*
    存放连接的Vector集合，初始值为null，存放的对象是PooledConnection型（有可以表示当前连接是否可用的属性）
     */
    private Vector connections = null;

    /*
     不同的用户数据库的url，username，password不同，这时只需到配置文件中db.properties修改即可
     */
    private static Properties p = new Properties();

    /*
    静态代码块，加载注册驱动，只需一次
     */
    static {

        try {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            InputStream is = cl.getResourceAsStream("db.properties");
            p.load(is);
            Class.forName(p.getProperty("driverClassName"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ConnectionPool() {
        try {
            /*
            在构造方法中调用构造连接池的方法，即构造了该类就立即创建连接池
             */
            this.createPool();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回连接池的连接的初始数量
     *
     * @return 初始连接池中可获得的连接数量
     */
    public int getInitialConnections() {
        return this.initialConnections;
    }

    /**
     * 设置连接池的连接的初始数量
     *
     * @param initialConnections 连接的初始数
     */
    public void setInitialConnections(int initialConnections) {
        this.initialConnections = initialConnections;
    }

    /**
     * 返回连接池自动增加的大小
     *
     * @return 连接池自动增加的大小
     */
    public int getIncrementalConnections() {
        return this.incrementalConnections;
    }

    /**
     * 设置连接池自动增加的连接数量
     *
     * @param incrementalConnections 自动增加连接的数量
     */
    public void setIncrementalConnections(int incrementalConnections) {
        this.incrementalConnections = incrementalConnections;
    }

    /**
     * 返回连接池中最大的可用连接数量
     *
     * @return 连接池中最大的可用连接数量
     */
    public int getMaxConnections() {
        return this.maxConnections;
    }

    /**
     * 设置连接池中的连接数的最大数量
     * @param maxConnections 连接数的最大数量
     */
    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    /**
     * 获取测试数据库表的名字
     *
     * @return 测试数据库表的名字
     */
    public String getTestTable() {
        return p.getProperty("driverClassName");
    }


    /**
     * 创建一个数据库连接池，连接池中的可用连接的数量采用类成员 initialConnections 中设置的值
     * @throws Exception 异常类型
     */
    public synchronized void createPool() throws Exception {
        /*
        确保连接池没有创建,如果连接池己经创建了，保存连接的connections不会为空
         */
        if (connections != null) {
            return;
        }
        /*
        加载并注册驱动
         */
        Driver driver = (Driver) (Class.forName(p.getProperty("driverClassName")).newInstance());
        DriverManager.registerDriver(driver);
        /*
        创建保存连接的容器,初始化时有 0 个元素
         */
        connections = new Vector();
        /*
        根据 initialConnections（初始的连接数） 中设置的值，创建连接，数量是初始值。
         */
        createConnections(this.initialConnections);
    }

    /**
     * 创建由 numConnections 指定数目的数据库连接 , 并把这些连接 放入 connections 向量中
     *
     * @param numConnections 要创建的数据库连接的数目，如果不使用默认值的话就需要手动输入该数量
     */
    private void createConnections(int numConnections) throws SQLException {
        // 循环创建指定数目的数据库连接
        for (int x = 0; x < numConnections; x++) {
            /*
            如果连接数己经达到最大，则退出。
             */
            if (this.maxConnections > 0 && this.connections.size() >= this.maxConnections) {
                break;
            }

            try {
                /*
                调用newConnection()方法来创建一个新连接并添加到连接池中（容器connections）
                 */
                connections.addElement(new PooledConnection(newConnection()));
                System.out.println(connections.get(x) + "连接创建好了..");
            } catch (SQLException e) {
                System.out.println(" 创建数据库连接失败！ " + e.getMessage());
                throw new SQLException();
            }
        }
        System.out.println("数据库连接池创建成功！");
    }

    /**
     * 创建一个新的数据库连接并返回它
     *
     * @return 返回一个新创建的数据库连接
     */
    private Connection newConnection() throws SQLException {
        /*
        创建一个数据库连接
         */
        Connection conn = DriverManager.getConnection(p.getProperty("url"),
                p.getProperty("username"), p.getProperty("password"));

        /*
        connections.size() == 0，表示当前还没有连接在连接池中
         */
        if (connections.size() == 0) {
            DatabaseMetaData metaData = conn.getMetaData();
            int driverMaxConnections = metaData.getMaxConnections();
            /*
            数据库返回的 driverMaxConnections 若为 0 ，表示此数据库没有最大连接限制，或数据库的最大连接限制不知道 ；
            driverMaxConnections 为返回的一个整数，表示此数据库允许客户连接的数目，如果连接池中设置的最大连接数量大于
            数据库允许的连接数目 , 则置连接池的最大连接数目为数据库允许的最大数目
             */
            if (driverMaxConnections > 0 && this.maxConnections > driverMaxConnections) {
                this.maxConnections = driverMaxConnections;
            }
        }
        return conn;
    }

    /**
     * 通过调用 getFreeConnection() 函数返回一个可用的数据库连接 , 如果当前没有可用的数据库连接，并且更多的数据库连接
     * 不能创建（如连接池大小的限制），此函数等待一会再尝试获取。
     *
     * @return 返回一个可用的数据库连接对象
     */
    public synchronized Connection getConnection() throws SQLException {
       /*
       确保连接池已经被创建了
        */
        if (connections == null) {
            return null;
        }
        /*
        获得一个可用的数据库连接,如果目前没有可以使用的连接，即所有的连接都在使用中，就等250ms在尝试获取一次
         */
        Connection conn = getFreeConnection();
        int num=0;
        while (conn == null) {
            num=num+1;
            wait(250);
            conn = getFreeConnection();
            /*
            如果请求100次之后还是失败，就返回null
             */
            if(num>100) {
                refreshConnections();
            }
        }
        return conn;// 返回获得的可用的连接
    }

    /**
     * 本方法从连接池 connections 中返回一个可用的的数据库连接，如果当前没有可用的数据库连接，本函数则根据incrementalConnections
     * （自动增加的连接数控）设置的值创建几个数据库连接，并放入连接池中。如果创建后，所有的连接仍都在使用中，则返回 null
     *
     * @return 返回一个可用的数据库连接
     */
    private Connection getFreeConnection() throws SQLException {
        /*
        从连接池中获得一个可用的数据库连接
         */
        Connection conn = findFreeConnection();
        if (conn == null) {
            /*
            如果目前连接池中没有可用的连接，创建一些连接(程序员没有指定incrementalConnections就默认为默认值)
             */
            createConnections(incrementalConnections);
            /*
            重新从池中查找是否有可用连接
             */
            conn = findFreeConnection();
            if (conn == null) {
                /*
                如果创建连接后仍获得不到可用的连接，则返回 null
                 */
                return null;
            }
        }
        System.out.println("您获取了连接：" + conn);
        return conn;
    }

    /**
     * 查找连接池中所有的连接，查找一个可用的数据库连接， 如果没有可用的连接，返回 null
     *
     * @return 返回一个可用的数据库连接
     */
    private Connection findFreeConnection() throws SQLException {
        Connection conn = null;
        PooledConnection pConn = null;
        /*
        获得连接池中所有的对象（即连接）
         */
        Enumeration enumerate = connections.elements();
        /*
        遍历所有的对象，看是否有可用的连接
         */
        while (enumerate.hasMoreElements()) {
            pConn = (PooledConnection) enumerate.nextElement();
            if (!pConn.isBusy()) {
                System.out.println(pConn + "一点也不忙~");
                /*
                如果此对象不忙，则获得它的数据库连接并把它设为忙
                 */
                conn = pConn.getConnection();
                pConn.setBusy(true);
                /*
                测试此连接是否可用，如果此连接不可再用了，则创建一个新的连接，并替换此不可用的连接对象，如果创建失败，返回 null
                 */
                if (!testConnection(conn)) {
                    System.out.println("连接不可用，测试失败~");
                    try {
                        conn = newConnection();
                    } catch (SQLException e) {
                        System.out.println(" 创建数据库连接失败！ " + e.getMessage());
                        return null;
                    }
                    pConn.setConnection(conn);
                }else {
                    System.out.println("此连接可用，测试成功");
                }
                /*
                己经找到一个可用的连接，退出
                 */
                break;
            } else {
                System.out.println(pConn + "有点点忙");
            }
        }
        return conn;
    }

    /**
     * 测试一个连接是否可用，如果不可用，关掉它并返回 false 否则可用并返回 true
     *
     * @param conn 需要测试的数据库连接
     * @return 返回 true 表示此连接可用， false 表示不可用
     */
    private boolean testConnection(Connection conn) {
        try {
            /*
            如果测试表为空，试着使用此连接的 setAutoCommit() 方法来判断连接否可用（此方法只在部分数据库可用，使用测试表的方法更可靠）
             */
            if (p.getProperty("testTable").equals("")) {
                conn.setAutoCommit(true);
            } else {
                Statement stmt = conn.createStatement();
                stmt.execute("SELECT count(*) FROM " + p.getProperty("testTable"));
            }
        } catch (SQLException e) {
            /*
            上面的测试抛出异常，表示此连接己不可用，关闭它，并返回 false;
             */
            closeConnection(conn);
            return false;
        }
        /*
        连接可用，返回 true
         */
        return true;
    }

    /**
     *  此函数返回一个数据库连接到连接池中，并把此连接置为空闲，所有使用连接池获得的数据库连接均应在不使用此连接时返回它。
     * @param conn 需要被返回到连接池的连接
     */
    public void returnConnection(Connection conn) {
        /*
        确保连接池存在，如果连接没有创建（不存在），直接返回
        */
        if (connections == null) {
            System.out.println(" 连接池不存在了，无法返回此连接到连接池中 !");
            return;
        }
        System.out.println(conn + "连接被返回了");
        PooledConnection pConn = null;
        Enumeration enumerate = connections.elements();
        /*
        遍历连接池中的所有连接，找到这个要返回的连接对象
         */
        while (enumerate.hasMoreElements()) {
            pConn = (PooledConnection) enumerate.nextElement();
            if (conn == pConn.getConnection()) {
                /*
                找到了 , 设置此连接为空闲状态
                 */
                pConn.setBusy(false);
                break;
            }
        }
    }

    /**
     * 刷新连接池中所有的连接对象
     */
    public synchronized void refreshConnections() throws SQLException {
        /*
        确保连接池己创新存在
         */
        if (connections == null) {
            System.out.println(" 连接池不存在，无法刷新 !");
            return;
        }
        System.out.println("数据库连接池刷新成功~");
        PooledConnection pConn = null;
        Enumeration enumerate = connections.elements();
        while (enumerate.hasMoreElements()) {
            /*
            获得一个连接对象
             */
            pConn = (PooledConnection) enumerate.nextElement();
            /*
            如果对象忙（用户正在使用）则等 5 秒 ,5 秒后直接刷新
             */
            if (pConn.isBusy()) {
                wait(5000);
            }
            /*
            关闭此连接，用一个新的连接代替它
             */
            closeConnection(pConn.getConnection());
            pConn.setConnection(newConnection());
            pConn.setBusy(false);
        }
    }

    /**
     * 关闭连接池中所有的连接，并清空连接池。
     */
    public synchronized void closeConnectionPool() throws SQLException {
        /*
        确保连接池存在，如果不存在，返回
         */
        if (connections == null) {
            System.out.println(" 连接池不存在，无法关闭 !");
            return;
        }
        System.out.println("连接池关闭成功！");
        PooledConnection pConn = null;
        Enumeration enumerate = connections.elements();
        while (enumerate.hasMoreElements()) {
            pConn = (PooledConnection) enumerate.nextElement();
            /*
            如果忙，等5秒，5秒后直接关闭它
             */
            if (pConn.isBusy()) {
                wait(5000);
            }
            closeConnection(pConn.getConnection());
            /*
            从连接池中删除它
             */
            connections.removeElement(pConn);
        }
        /*
        设置连接池为空
         */
        connections = null;
    }

    /**
     * 关闭一个数据库连接
     */
    private void closeConnection(Connection conn) {
        try {
            conn.close();
            System.out.println(conn + "连接关闭成功");
        } catch (SQLException e) {
            System.out.println(" 关闭数据库连接出错： " + e.getMessage());
        }
    }

    /**
     * 使程序等待给定的毫秒数
     */
    private void wait(int mSeconds) {
        try {
            Thread.sleep(mSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 内部使用的用于保存连接池中连接对象的类，此类中有两个成员，一个是数据库的连接，另一个是指示此连接是否正在使用的标志。
     */
    class PooledConnection {
        /*
        数据库连接
         */
        Connection connection = null;
        /*
        此连接是否正在使用的标志，默认没有正在使用
         */
        boolean busy = false;

        /*
        构造函数，根据一个 Connection 构造一个 PooledConnection 对象
         */
        public PooledConnection(Connection connection) {
            this.connection = connection;
        }

        /*
        返回此对象中的连接
         */
        public Connection getConnection() {
            return connection;
        }

        /*
        设置此对象的连接
         */
        public void setConnection(Connection connection) {
            this.connection = connection;
        }

        /*
        获得对象连接是否忙
         */
        public boolean isBusy() {
            return busy;
        }

        /*
        设置对象的连接正在忙
         */
        public void setBusy(boolean busy) {
            this.busy = busy;
        }
    }
}


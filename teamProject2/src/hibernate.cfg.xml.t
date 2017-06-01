<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
	<session-factory>
		<property name="connection.driver_class">com.mysql.jdbc.Driver</property>
		<property name="connection.url">jdbc:mysql://localhost:3306/javaee</property>
		<property name="connection.username">root</property>
		<property name="connection.password">mysql</property>
		<property name="dialect">org.hibernate.dialect.MySQLDialect</property>

		<property name="connection.provider_class">org.hibernate.connection.C3P0ConnectionProvider</property>
		<property name="initialPoolSize">3</property>
		<property name="minPoolSize">3</property>
		<property name="maxPoolSize">5</property>
		<property name="acquireIncrement">3</property>
		<property name="maxStatements">8</property>
		<property name="maxStatementsPerConnection">5</property>
		<property name="maxIdleTime">1800</property>

		<property name="show_sql">true</property>
		<property name="hbm2ddl.auto">update</property>

		<mapping resource="com/lqh/vo/Book.hbm.xml" />
		<mapping resource="com/lqh/vo/Lend.hbm.xml" />
		<mapping resource="com/lqh/vo/Login.hbm.xml" />
		<mapping resource="com/lqh/vo/Student.hbm.xml" />

	</session-factory>
</hibernate-configuration>
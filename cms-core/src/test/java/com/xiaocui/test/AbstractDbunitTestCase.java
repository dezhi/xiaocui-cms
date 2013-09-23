package com.xiaocui.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatDtdDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.dbunit.operation.DatabaseOperation;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.xml.sax.InputSource;

public class AbstractDbunitTestCase {

	public static IDatabaseConnection dbunitConn;

	// 临时xml文件
	// 用来存储数据库的备份数据
	private File tempXml;

	// 临时dtd文件
	// 用户存储数据库的备份数据
	private File tempDtd;

	@BeforeClass
	public static void init() throws DatabaseUnitException, SQLException {
		dbunitConn = new DatabaseConnection(Dbunit.getConnection());
	}

	// 根据文件名创建dataset对象
	protected IDataSet createDataSet(String tableName) throws DataSetException,
			FileNotFoundException, IOException {
		InputStream is = AbstractDbunitTestCase.class.getClassLoader()
				.getResourceAsStream(tableName + ".xml");

		Assert.assertNotNull("dbunit获取的数据不存在", is);

		// 通过dtd和传入的文件创建测试的IDataSet
		return new FlatXmlDataSet(new FlatXmlProducer(new InputSource(is),
				new FlatDtdDataSet(new FileReader(tempDtd))));
	}

	// 将表数据写入临时文件中
	private void writerBackFile(IDataSet ds) throws DataSetException,
			IOException {

		tempXml = File.createTempFile("back", "xml");

		tempDtd = File.createTempFile("back", "dtd");

		// 写DTD
		FlatDtdDataSet.write(ds, new FileWriter(tempDtd));

		// 写数据表文件
		FlatXmlDataSet.write(ds, new FileWriter(tempXml));
	}

	/**
	 * 备份所有表
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws DataSetException
	 */
	protected void backupAllTable() throws SQLException, IOException,
			DataSetException {
		IDataSet ds = dbunitConn.createDataSet();

		writerBackFile(ds);
	}

	/**
	 * 备份自选表
	 * 
	 * @param tableName
	 * @throws DataSetException
	 * @throws IOException
	 */
	protected void backupCustomTable(String[] tableName)
			throws DataSetException, IOException {
		QueryDataSet qds = new QueryDataSet(dbunitConn);

		for (String string : tableName) {
			qds.addTable(string);
		}

		writerBackFile(qds);
	}

	/**
	 * 备份一张表
	 * 
	 * @param tableName
	 * @throws DataSetException
	 * @throws IOException
	 */
	protected void backupOneTable(String tableName) throws DataSetException,
			IOException {
		backupCustomTable(new String[] { tableName });
	}

	/**
	 * 还原数据表
	 * 
	 * @throws DatabaseUnitException
	 * @throws SQLException
	 * @throws IOException
	 */
	protected void resumeTable() throws DatabaseUnitException, SQLException,
			IOException {

		// 创建ds的时候，引入相应的dtd文件
		IDataSet ds = new FlatXmlDataSet(new FlatXmlProducer(new InputSource(
				new FileInputStream(tempXml)), new FlatDtdDataSet(
				new FileReader(tempDtd))));

		DatabaseOperation.CLEAN_INSERT.execute(dbunitConn, ds);
	}

	// 清空数据
	@AfterClass
	public static void destory() {
		try {
			if (dbunitConn != null)
				dbunitConn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

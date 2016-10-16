package com.tinyspark;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Nypro on 2/19/2016.
 */
public class NyproDB
{

	private enum InstantiationType
	{
		FILE_CREATE, FILE_OPEN
	}

	private RandomAccessFile mainDBRaf;
	private RandomAccessFile instanceDBRaf;
	private short [] mainDBDimen;
	private short [] instanceDBDimen;
	private boolean isClosed = true;
	private DBMetaData dbMetaData;
	private String mainDBFileName;
	private String instanceDBFileName;



	// CONSTRUCTOR
	private NyproDB()
	{
		// NADA
	}



	// CONSTRUCTOR
	private NyproDB(String mainDBFileName, String instanceDBFIleName, InstantiationType instantiationType)
	{
		mainDBDimen = new short [2];
		instanceDBDimen = new short [3];
		this.mainDBFileName = mainDBFileName;
		this.instanceDBFileName = instanceDBFIleName;

		if(instantiationType == InstantiationType.FILE_CREATE)
		{
			try
			{
				mainDBDimen[0] = 50;
				mainDBDimen[1] = 5;
				instanceDBDimen[0] = 50;
				instanceDBDimen[1] = 50;
				instanceDBDimen[2] = 50;
				isClosed = false;

				// TODO: point mainDBRaf and instanceDBRaf to new files
				// TODO: call updateMainDBFile
				// TODO: call updateInstanceDBFile
			}
			catch(IOException ioe)
			{
				System.err.println("File Cannot Be Created!");
				ioe.printStackTrace();
			}
		}
		else
		{
			try
			{
				// TODO: point mainDBRaf and instanceDBRaf to existing files
				// TODO: call updateMainDBFile
				// TODO: call updateInstanceDBFile

				mainDBDimen[0] = dbMetaData.colCapacity;
				mainDBDimen[1] = dbMetaData.rowCapacity;
				instanceDBDimen[0] = ;
				instanceDBDimen[1] = ;
				instanceDBDimen[2] = ;
				isClosed = false;
			}
			catch(FileNotFoundException fnfe)
			{
				System.err.println("File Not Found!");
				fnfe.printStackTrace();
			}
		}


	}



	// UPDATE_MAIN_DB_FILE
	private void updateMainDBFile()
	{
		// TODO: call mainDBRaf.setLength after necessary calc of how large the file should be
		// TODO: Be sure to copy old elements into the new one, that means you have to rename old file first
		// TODO: call collectMetaData
	}


	// UPDATE_INSTANCE_DB_FILE
	private void updateInstanceDBFile()
	{
		// TODO: call instanceDBRaf.setLength after necessary calc of how large the file should be
		// TODO: Be sure to copy old elements into the new one, that means you have to rename old file first. If old file contains nothing just skip
		// TODO: call collectMetaData
	}



	// ::ANDROID::
	// CREATE_INTERNAL_DB
	public static NyproDB createInternalDB(String mainDBFileName, String instanceDBFIleName)
	{
		return new NyproDB(mainDBFileName, instanceDBFIleName, InstantiationType.FILE_CREATE);
	}

	// ::ANDROID::
	// OPEN_INTERNAL_DB
	public static NyproDB openInternalDB(String mainDBFilePath, String instanceDBFilePath)
	{
		return new NyproDB(mainDBFilePath, instanceDBFilePath, InstantiationType.FILE_OPEN);
	}


	///////////////////////////////////////SET AND GET MAIN_DB///////////////////////////////////////////////////



	// SET_MAIN_DB_DIMEN
	public NyproDB setMainDBDimen(short colCapacity, short rowCapacity)
	{
		if (isClosed)
			return this;
		try
		{
			if (colCapacity <= 0 || rowCapacity <= 0)
			{
				throw new NumberBelowOneException();
			}

			mainDBDimen[0] = colCapacity;
			mainDBDimen[1] = rowCapacity;

			// TODO: call updateMainDBFile

			return this;
		}
		catch (NumberBelowOneException nboe)
		{
			System.err.println("Number can't be zero!");
			nboe.printStackTrace();
		}
		finally
		{
			try
			{
				if (mainDBRaf != null)
					mainDBRaf.close();
				if (instanceDBRaf!= null)
					instanceDBRaf.close();
			}
			catch (IOException ioe)
			{
				System.err.println("IOException");
				ioe.printStackTrace();
			}
		}

		return this;
	}



	// SET_COL_CAPACITY
	public void setColCapacity (short colCapacity)
	{
		if (isClosed)
			return;
		try
		{
			if (colCapacity <= 0)
			{
				throw new NumberBelowOneException();
			}

			mainDBDimen[0] = colCapacity;

			// TODO: call updateMainDBFile

		}
		catch (NumberBelowOneException nboe)
		{
			System.err.println("Number can't be zero!");
			nboe.printStackTrace();
		}
		finally
		{
			try
			{
				if (mainDBRaf != null)
					mainDBRaf.close();
				if (instanceDBRaf!= null)
					instanceDBRaf.close();
			}
			catch (IOException ioe)
			{
				System.err.println("IOException");
				ioe.printStackTrace();
			}
		}
	}



	//SET_ROW_CAPACITY
	public void setRowCapacity (short rowCapacity)
	{
		if (isClosed)
			return;
		try
		{
			if (rowCapacity <= 0)
			{
				throw new NumberBelowOneException();
			}

			mainDBDimen[1] = rowCapacity;

			// TODO: call updateMainDBFile

		}
		catch (NumberBelowOneException nboe)
		{
			System.err.println("Number can't be zero!");
			nboe.printStackTrace();
		}
		finally
		{
			try
			{
				if (mainDBRaf != null)
					mainDBRaf.close();
				if (instanceDBRaf!= null)
					instanceDBRaf.close();
			}
			catch (IOException ioe)
			{
				System.err.println("IOException");
				ioe.printStackTrace();
			}
		}
	}


	// GET_COL_CAPACITY
	public short getColCapacity ()
	{
		return mainDBDimen[0];
	}

	// GET_ROW_CAPACITY
	public short getRowCapacity ()
	{
		return mainDBDimen[1];
	}





	//////////////////////////////////////////////////SET AND GET INSTANCE_DB/////////////////////////////////////////////////////////////////////



	// SET_INSTANCE_DB_DIMEN
	public NyproDB setInstanceDBDimen(short titleCapacity, short boxCapacity, short cellCapacity)
	{
		if (isClosed)
			return this;
		try
		{
			if (titleCapacity <= 0 || boxCapacity <= 0 || cellCapacity <= 0)
			{
				throw new NumberBelowOneException();
			}

			instanceDBDimen[0] = titleCapacity;
			instanceDBDimen[1] = boxCapacity;
			instanceDBDimen[2] = cellCapacity;

			// TODO: call updateInstanceDBFile

			return this;
		}
		catch (NumberBelowOneException nboe)
		{
			System.err.println("Number can't be zero!");
			nboe.printStackTrace();
		}
		finally
		{
			try
			{
				if (mainDBRaf != null)
					mainDBRaf.close();
				if (instanceDBRaf!= null)
					instanceDBRaf.close();
			}
			catch (IOException ioe)
			{
				System.err.println("IOException");
				ioe.printStackTrace();
			}
		}

		return this;
	}

	// SET_FIRST_DIMEN_CAPACITY
	public void settitleCapacity (short titleCapacity)
	{
		if (isClosed)
			return;
		try
		{
			if (titleCapacity <= 0)
			{
				throw new NumberBelowOneException();
			}

			instanceDBDimen[0] = titleCapacity;

			// TODO: call updateInstanceDBFile

		}
		catch (NumberBelowOneException nboe)
		{
			System.err.println("Number can't be zero!");
			nboe.printStackTrace();
		}
		finally
		{
			try
			{
				if (mainDBRaf != null)
					mainDBRaf.close();
				if (instanceDBRaf!= null)
					instanceDBRaf.close();
			}
			catch (IOException ioe)
			{
				System.err.println("IOException");
				ioe.printStackTrace();
			}
		}
	}

	// SET_SECOND_DIMEN_CAPACITY
	public void setboxCapacity (short boxCapacity)
	{
		if (isClosed)
			return;
		try
		{
			if (boxCapacity <= 0)
			{
				throw new NumberBelowOneException();
			}

			instanceDBDimen[1] = boxCapacity;

			// TODO: call updateInstanceDBFile

		}
		catch (NumberBelowOneException nboe)
		{
			System.err.println("Number can't be zero!");
			nboe.printStackTrace();
		}
		finally
		{
			try
			{
				if (mainDBRaf != null)
					mainDBRaf.close();
				if (instanceDBRaf!= null)
					instanceDBRaf.close();
			}
			catch (IOException ioe)
			{
				System.err.println("IOException");
				ioe.printStackTrace();
			}
		}
	}

	// SET_THIRD_DIMEN_CAPACITY
	public void setcellCapacity (short cellCapacity)
	{
		if (isClosed)
			return;
		try
		{
			if (cellCapacity <= 0)
			{
				throw new NumberBelowOneException();
			}

			instanceDBDimen[2] = cellCapacity;

			// TODO: call updateInstanceDBFile

		}
		catch (NumberBelowOneException nboe)
		{
			System.err.println("Number can't be zero!");
			nboe.printStackTrace();
		}
		finally
		{
			try
			{
				if (mainDBRaf != null)
					mainDBRaf.close();
				if (instanceDBRaf!= null)
					instanceDBRaf.close();
			}
			catch (IOException ioe)
			{
				System.err.println("IOException");
				ioe.printStackTrace();
			}
		}
	}


	// GET_FIRST_DIMEN_CAPACITY
	public short gettitleCapacity ()
	{
		return instanceDBDimen[0];
	}

	// GET_SECOND_DIMEN_CAPACITY
	public short getboxCapacity ()
	{
		return instanceDBDimen[1];
	}

	// GET_THIRD_DIMEN_CAPACITY
	public short getcellCapacity ()
	{
		return instanceDBDimen[2];
	}




	////////////////////////////////////////////////////////DATABASE READ AND WRITE///////////////////////////////////////////

	public void updateMetaData()
	{
		// TODO: Parse mainDB and instanceDB files and store metadata in dbMetaData
	}

	///////////////////////MAIN_DB////////////////////////////
	public void setCols(String newColIDs)
	{
		// TODO: get some MetaData details and use it to create new colIDs
		// TODO: set MetaData if necessary
		// TODO: call updateMetaData
	}

	public void addRow(String values)
	{
		// TODO: get some metaData and col Data and create a new row
		// TODO: set MetaData if necessary
		// TODO: call updateMetaData
	}

	public void getValueAt (String key, short rowIndex)
	{
		// TODO
	}

	public void getColIDAt (String key, short rowIndex)
	{
		// TODO
	}

	///////////////////////INSTANCE_DB/////////////////////////
	public void setTitles (String newTitleIDs)
	{
		// TODO: get some MetaData details and use it to create new colIDs
		// TODO: set MetaData if necessary
		// TODO: call updateMetaData
	}

	public void addBoxes (String titleID, String newBoxIDs)
	{
		// TODO
	}

	public void addCells (String titleID, String boxID, String newCellIDs)
	{
		// TODO
	}

	public void getTitle (String titleIndex)
	{
		// TODO
	}

	public void getBoxes (String titleID, String boxIndex)
	{
		// TODO
	}

	public void getCells (String titleID, String boxID, short cellIndex)
	{
		// TODO
	}







	////////////////////////////////////////////////////////////CLOSE AND REOPEN/////////////////////////////////////////////////////////



	// CLOSE
	public void close()
	{
		if (isClosed)
			return;
		try
		{
			isClosed = true;
		}
		finally
		{
			try
			{
				if (mainDBRaf != null)
					mainDBRaf.close();
				if (instanceDBRaf!= null)
					instanceDBRaf.close();
			}
			catch (IOException ioe)
			{
				System.err.println("IOException");
				ioe.printStackTrace();
			}
		}
	}



	public void reopen()
	{
		isClosed = false;
		try
		{
			// TODO: point mainDBRaf and instanceDBRaf to existing files
			// TODO: call updateMainDBFile
			// TODO: call updateInstanceDBFile
		}
		catch(FileNotFoundException fnfe)
		{
			System.err.println("File Not Found!");
			fnfe.printStackTrace();
		}
	}

}

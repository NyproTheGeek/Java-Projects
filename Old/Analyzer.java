package com.tinyspark;

import java.io.FileReader;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Nypro on 3/7/2016.
 */
public class Analyzer
{

	private static Scanner sc = null;
	private static ArrayList<Integer> data = new ArrayList<>();
	private static HashMap<Integer, Integer> frequencyTable = new HashMap<>();
	private static HashMap<String, Float> togetherness = new HashMap<>();

	public static void showAnalysis(String filePath, float least)
	{
		try
		{
			sc = new Scanner(new FileReader(filePath));
			String strTemp;
			StringTokenizer lineTokens;
			int token;

			while (sc.hasNextLine())
			{
				strTemp = sc.nextLine();
				lineTokens = new StringTokenizer(strTemp, ", ", false);

				while (lineTokens.hasMoreTokens())
				{
					// store data in arrayList
					token = Integer.parseInt(lineTokens.nextToken());
					data.add(token);
				}

				data.add(0);
			}


//			// TODO
//			// FUCKING ITERATOR! DON'T USE IT! IT WILL REARRANGE THE ORDER
//			for(int i = 0; i < data.size() ; i++)
//			{
//				System.out.println(data.get(i));
//			}


			// Do computation (frequency, data that appear together often on a line) here
			// Print everything here.

			int arrayLength = data.size();
			Integer contentAtIndex;
			boolean isFirstIter = true;


			// FREQUENCY
			for (int a = 0; a < arrayLength; a++)
			{
				contentAtIndex = data.get(a);

				// Safe check
				int b = (a > 0) ? a - 1 : 0;



				// Comparing current data with previous data
				for (; b > 0; b--)
				{
					if (isFirstIter)
					{
						if (contentAtIndex.equals(0))
						{
							continue;
						}

						frequencyTable.put(contentAtIndex, 1);
					}

					if (contentAtIndex.equals(data.get(b)))
					{
						// Update the key's value
						frequencyTable.put(contentAtIndex, frequencyTable.get(contentAtIndex) + 1);
					}

					isFirstIter = false;
				}

				isFirstIter = true;

			}

			// Display Frequency Table
			for(Integer i : frequencyTable.keySet())
			{
				System.out.println("Key: " + i + " | Value: " + frequencyTable.get(i));
			}



			{

				boolean aIsFound = false;
				boolean bIsFound = false;


				for(Integer a : frequencyTable.keySet())
				{
					int line = 1;

					outer:
					for(Integer b : frequencyTable.keySet())
					{

						if(a.equals(b))
							continue;

						// if togetherness is not empty and the key association already exists go to te next key
						if(!togetherness.isEmpty())
						{
							for (String c : togetherness.keySet())
							{
								if (c.equals(b + " - " + a) || c.equals(a + " - " + b) )
									continue outer;
							}
						}

						float avg = 0f;
						int togetherOccur = 0;
						int anyOccur = 0;

						for (int i = 0; i < data.size() ; i++)
						{
							if(a.equals(data.get(i)))
							{
								aIsFound = true;
							}

							if(b.equals(data.get(i)))
							{
								bIsFound = true;
							}

							if (data.get(i).equals(0))
							{
								if(aIsFound && bIsFound)
								{
									++anyOccur;
									++togetherOccur;
								}

								if((aIsFound && !bIsFound) || (bIsFound && !aIsFound))
								{
									++anyOccur;
								}

								line++; // Kinda redundant here
								aIsFound = false;
								bIsFound = false;
							}


						}

						avg = (float) togetherOccur/anyOccur; // FUCKING IMPLICIT CONVERSION. PLS ALWAYS DO IT EXPLICITLY TO PREVENT MADNESS

//						// TODO
//						System.out.println("Average: " + avg );
//						System.out.println("TogetherOccur: " + togetherOccur);
//						System.out.println("AnyOccur: " + anyOccur );

						togetherness.put(a + " - " + b, avg * 100);


					}
				}

			}

			// Display
			for(String i : togetherness.keySet())
			{
				if(togetherness.get(i) > least )
				{
					System.out.println("Association: " + i + " | Average: " + togetherness.get(i));
				}
			}

		}
		catch (IOException ioe)
		{
			System.err.print("IO Error!");
			ioe.printStackTrace();
			sc.close();
		}
		finally
		{
			sc.close();
		}
	}

	public static void showAverage(String key)
	{
		System.out.println("Association: " + key + " | Average: " + togetherness.get(key));
	}
}
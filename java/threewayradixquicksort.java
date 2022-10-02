// Java program for 3-Way Radix Quicksort

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class threewayradixquicksort {

	// swapping method.
	public static void swp(String[] s, int x, int y)
	{
		String tmp = s[x];
		s[x] = s[y];
		s[y] = tmp;
	}

	// sort method.
	public static void srt(String[] s, int start, int last,
						int character_index)
	{
		// base condition if no further index possible.
		if (start >= last)
			return;

		// first making a start pointer for dividing the
		// list from start to start_pointer.
		int start_pointer = start;

		// last_pointer and last are the boundaries for the
		// third list.
		int last_pointer = last;

		// taking the ascii value of the pivot at the index
		// given.
		int char_ascii_value_pivot
			= s[start].charAt(character_index);

		int pointer = start + 1;

		// starting a pointer to scan the whole array to
		// sort.
		while (pointer <= last) {

			// ASCII value of char at the position of all
			// the strings to compare with that of the pivot
			// char.
			int char_ascii_value_element
				= s[pointer].charAt(character_index);

			// if the element has char less than pivot than
			// swapping it with the top element and
			// incrementing the top boundary of the first
			// list.
			if (char_ascii_value_pivot
				> char_ascii_value_element) {
				swp(s, start_pointer, pointer);
				start_pointer++;

				// incrementing the pointer to check for
				// next string.
				pointer++;
			}
			else

				// if found larger character than it is
				// replaced by the element at last_pointer
				// and lower boundary is raised by
				// decrementing it.
				if (char_ascii_value_pivot
					< char_ascii_value_element) {
				swp(s, last_pointer, pointer);
				last_pointer--;
				pointer++;
			}

			// if character is the same as that of the pivot
			// then no need to swap and move the pointer on
			else {
				pointer++;
			}
		}

		// now performing same sort on the first list
		// bounded by start and start_pointer with same
		// character_index
		srt(s, start, start_pointer - 1, character_index);

		// if we have more character left in the pivot
		// element than recall quicksort on the second list
		// bounded by start_pointer and last_pointer and
		// next character_index.
		if (char_ascii_value_pivot >= 0)

			srt(s, start_pointer, last_pointer,
				character_index + 1);

		// lastly the third list with boundaries as
		// last_pointer and last.
		srt(s, last_pointer + 1, last, character_index);
	}

	public static void main(String[] args) throws Exception
	{
		// predefined array of five element all of same
		// length.
		String s[]
			= { "some", "same", "hero", "make", "zero" };

		// calling sort function to sort the array using
		// 3-way-radix-quicksort.
		srt(s, 0, 4, 0);

		// printing the sorted array;
		// here we are calling function by passing parameters
		// using references .
		for (int i = 0; i < 5; ++i)
			System.out.println(s[i]);
	}
}

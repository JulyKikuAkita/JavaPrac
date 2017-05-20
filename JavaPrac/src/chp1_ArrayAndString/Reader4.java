/**
 * 
 */
package chp1_ArrayAndString;

import java.util.Arrays;

public class Reader4 {
/*
# python code
# The read4 API is already defined for you.
# @param buf, a list of characters
# @return an integer

def read4(buf):
    global file_content
    i = 0
    while i < len(file_content) and i < 4:
        buf[i] = file_content[i]
        i += 1
    
    if len(file_content) > 4:
        file_content = file_content[4:]
    else:
        file_content = ""
    return i
*/
	
	public int read4(char[] buf){ // read4 saves 4 char to buf ?
		char[] file_content = "fileInput".toCharArray();
		int i = 0;
		while( i < file_content.length && i < 4){
			buf[i] = file_content[i];
			i += 1;
		}
		
		if(file_content.length > 4){
			// System.arraycopy(src, srcPos, dest, destPos, length)
			//Arrays.copyOfRange(original, from, to);
			char[] rest = Arrays.copyOfRange(file_content, 4, file_content.length);
			file_content = rest;
			
		}else{
			file_content = null;
		}
		return i;
	}
	
	public static void main(String[] args) {
		char[] file_content = "fileInput".toCharArray();
		
		
		System.out.println(Arrays.copyOfRange(file_content, 4, file_content.length));

	}

}

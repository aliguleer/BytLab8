import java.io.PrintStream;

public class CsvWriter {
	
	private final PrintStream printStream;
	
	public CsvWriter() {
		
		 this.printStream = System.out;
	}
	
	  public CsvWriter(PrintStream printStream) {
	        this.printStream = printStream;
	    }
	  

	public void write(String[][] lines) {
		for (int i = 0; i < lines.length; i++)
			writeLine(lines[i]);
	}

	private void writeLine(String[] fields) {
		if (fields.length == 0)
			printStream.println();
		else {
			writeField(fields[0]);

			for (int i = 1; i < fields.length; i++) {
				printStream.print(",");
				writeField(fields[i]);
			}
			printStream.println();
		}
	}

	private void writeField(String field) {
		if (field.indexOf(',') != -1 || field.indexOf('\"') != -1)
			writeQuoted(field);
		else
			printStream.print(field);
	}

	private void writeQuoted(String field) {
		printStream.print('\"');
		for (int i = 0; i < field.length(); i++) {
			char c = field.charAt(i);
			if (c == '\"')
				printStream.print("\"\"");
			else
				printStream.print(c);
		}
		printStream.print('\"');
	}
}
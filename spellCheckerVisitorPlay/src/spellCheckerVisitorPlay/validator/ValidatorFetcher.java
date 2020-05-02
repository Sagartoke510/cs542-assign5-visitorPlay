package spellCheckerVisitorPlay.validator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import spellCheckerVisitorPlay.userDefinedException.KValueException;

/**
 * The class {@code ValidatorFetcher} is to validate input from command line
 */
public class ValidatorFetcher {
	public static Validator missingFileValidator(String inputFilePath) {
		return new Validator() {
			@Override
			public void run() throws FileNotFoundException {
				if (!Files.exists(Paths.get(inputFilePath))) {
					throw new FileNotFoundException("Invalid input file or input file in incorrect location");
				}
			}
		};
	}

	public static Validator emptyFileValidator(String inputFilePath) {
		return new Validator() {
			@Override
			public void run() throws IOException {
				File file = new File(inputFilePath);
				if (file.length() == 0) {
					throw new IOException("Input file is empty");
				}

			}
		};
	}

	public static Validator fileContentValidator(String inputFilePath) {
		return new Validator() {
			@Override
			public void run() throws IOException {
				String text = "";
				String pattern = "^[a-zA-Z\\ \\.]*$";
				text = new String(Files.readAllBytes(Paths.get(inputFilePath)));
				if (!text.matches(pattern)) {
					throw new IOException("Invalid line or line contains other than characters.");
				}

			}
		};
	}
	public static Validator fileContentValidatorAccept(String acceptableWordFile) {
		return new Validator() {
			@Override
			public void run() throws IOException {
				String text = "";
				String pattern = "^[a-zA-Z\\r\\n]*$";
				text = new String(Files.readAllBytes(Paths.get(acceptableWordFile)));
				if (!text.matches(pattern)) {
					throw new IOException("Invalid line or line contains more than one word");
				}

			}
		};
	}

	public static Validator kValueValidator(String k) {
		return new Validator() {

			@Override
			public void run() throws KValueException {
				if (Integer.parseInt(k) <= 0)
					throw new KValueException("Invalid value for K");
			}
		};
	}

}

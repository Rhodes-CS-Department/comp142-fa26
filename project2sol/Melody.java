import java.util.*;
import java.io.*;
import melody.audio.*;

public class Melody {
	private String title;
	private String artist;
	private Note[] notes;

	public Melody(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		title = scanner.nextLine();
		artist = scanner.nextLine();
		int numNotes = scanner.nextInt();
		
		notes = new Note[numNotes];
		for (int i = 0; i < numNotes; i++) {
			double duration = scanner.nextDouble();
			Pitch pitch = Pitch.getValueOf(scanner.next());

			if (pitch == Pitch.R) {
				boolean repeat = scanner.nextBoolean();
				notes[i] = new Note(duration, repeat);
			} else {
				int octave = scanner.nextInt();
				Accidental accidental = Accidental.getValueOf(scanner.next());
				boolean repeat = scanner.nextBoolean();
				notes[i] = new Note(duration, pitch, octave, accidental, repeat);
			}
		}

		scanner.close();
	}
	
	public void changeTempo(double ratio) {
		for (Note note : notes) {
			note.setDuration(note.getDuration() * ratio);
		}
	}
	
	public String getArtist() {
		return artist;
	}

	public String getTitle() {
		return title;
	}
	
	public double getTotalDuration() {
		double duration = 0;

		boolean repeat = false;
		for (Note note : notes) {
			if (repeat || note.isRepeat()) {
				duration += 2 * note.getDuration();
			} else {
				duration += note.getDuration();
			}

			if (note.isRepeat()) {
				repeat = !repeat;
			}
		}

		return duration;
	}
	
	public boolean octaveDown() {
		for (Note note : notes) {
			if (note.getOctave() <= 1) {
				return false;
			}
		}

		for (Note note : notes) {
			note.setOctave(note.getOctave() - 1);
		}

		return true;
	}
	
	public boolean octaveUp() {
		for (Note note : notes) {
			if (note.getOctave() >= 10) {
				return false;
			}
		}

		for (Note note : notes) {
			note.setOctave(note.getOctave() + 1);
		}

		return true;
	}
	
	/**
	 * Compute the index of the next repeat note after `i`, or -1 if none.
	 * @param i an index of a repeat note
	 * @return the index of the next repeat note, or -1 if none
	 */
	private int nextRepeat(int i) {
		for (int j = i + 1; j < notes.length; j++) {
			if (notes[j].isRepeat()) {
				return j;
			}
		}

		return -1;
	}

	/**
	 * Play all notes from index i to j, inclusive.
	 * @param i index of the first note to play
	 * @param j index of the last note to play
	 */
	private void playRange(int i, int j) {
		for (int k = i; k <= j; k++) {
			notes[k].play();
		}
	}

	public void play() {
		int i = 0;

		while (i < notes.length) {
			if (notes[i].isRepeat()) {
				int j = nextRepeat(i);
				playRange(i, j);
				playRange(i, j);
				i = j + 1;
			} else {
				notes[i].play();
				i++;
			}
		}
	}
	
	public void reverse() {
		Note[] newNotes = new Note[notes.length];
		for (int i = 0; i < notes.length; i++) {
			newNotes[i] = notes[notes.length - i - 1];
		}

		notes = newNotes;
	}
	
	public String toString() {
		String str = "";
		str += "\nTitle: " + title;
		str += "\nArtist: " + artist;

		for (Note note : notes) {
			str += "\n" + note.toString();
		}

		return str;
	}
}


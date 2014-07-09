package music;

import java.io.FileInputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class MusicPlay {

	public static void playOrder(){
		try {
			FileInputStream fileau = new FileInputStream("D:/orderMusic.wav");
			AudioStream as = new AudioStream(fileau);
			AudioPlayer.player.start(as);
		} catch (Exception e) {
			System.out.println("Ê§°Ü¿©£¡");
		}
	}
}

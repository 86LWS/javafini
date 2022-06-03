package rr.function;

import java.io.File;
import java.net.MalformedURLException;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
/**
 * 音乐播放
 * @author Administrator
 *
 */
public class playmusic {
	private Media me;
	private MediaPlayer pl;
	public playmusic() {
		try {
			me=new Media(new File("src/rr/music/bg.mp3").toURL().toString());
			pl=new MediaPlayer(me);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	public void play() {
		pl.play();
	}
}

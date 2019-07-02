import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sounds {
	AudioInputStream loseais;
	Clip lose;
	AudioInputStream eggthrowais;
	Clip eggthrow;
	AudioInputStream scoreais;
	Clip score;
	AudioInputStream cathitais;
	Clip cathit;
	
	public Sounds()
	{
		try {
			loseais = AudioSystem.getAudioInputStream(new File("src//lose.wav").getAbsoluteFile());
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}
		try {
			lose = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		try {
			lose.open(loseais);
		} catch (LineUnavailableException | IOException e) {
			e.printStackTrace();
		}
		try {
			eggthrowais = AudioSystem.getAudioInputStream(new File("src//throwegg.wav").getAbsoluteFile());
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}
		try {
			eggthrow = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		try {
			eggthrow.open(eggthrowais);
		} catch (LineUnavailableException | IOException e) {
			e.printStackTrace();
		}
		
		try {
			scoreais = AudioSystem.getAudioInputStream(new File("src//score.wav").getAbsoluteFile());
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}
		try {
			score = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		try {
			score.open(scoreais);
		} catch (LineUnavailableException | IOException e) {
			e.printStackTrace();
		}
		try {
			cathitais = AudioSystem.getAudioInputStream(new File("src//cathit.wav").getAbsoluteFile());
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}
		try {
			cathit = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		try {
			cathit.open(cathitais);
		} catch (LineUnavailableException | IOException e) {
			e.printStackTrace();
		}	
	}
	
	protected void cathit()
	{
		cathit.start();
		if(cathit.getFrameLength()==cathit.getFramePosition())
		{
			cathit.setFramePosition(0);
		}
	}
	protected void score()
	{
		score.start();
		if(score.getFrameLength()==score.getFramePosition())
		{
			score.setFramePosition(0);
		}
	}
	protected void eggsound()
	{
		if(eggthrow.getFrameLength()==eggthrow.getFramePosition())
		{
			eggthrow.setFramePosition(0);
		}
		eggthrow.start();
	}
	protected void lostsound()
	{
		lose.start();
		if(lose.getFrameLength()==lose.getFramePosition())
		{
		lose.setFramePosition(0);	
		}		
	}
}

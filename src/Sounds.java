import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sounds {
	
	protected static AudioInputStream loseais;
	protected static Clip lose;
	protected static AudioInputStream eggthrowais;
	protected static Clip eggthrow;
	protected static AudioInputStream scoreais;
	protected static Clip score;
	protected static AudioInputStream cathitais;
	protected static Clip cathit;
	protected static AudioInputStream m2ais;
	protected static Clip m2;
	
	public Sounds()
	{
		try {
			m2ais = AudioSystem.getAudioInputStream(new File("sounds//m2.wav").getAbsoluteFile());
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}
		try {
			m2 = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		try {
			m2.open(m2ais);
		} catch (LineUnavailableException | IOException e) {
			e.printStackTrace();
		}
		try {
			loseais = AudioSystem.getAudioInputStream(new File("sounds//lose.wav").getAbsoluteFile());
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
			eggthrowais = AudioSystem.getAudioInputStream(new File("sounds//throwegg.wav").getAbsoluteFile());
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
			scoreais = AudioSystem.getAudioInputStream(new File("sounds//score.wav").getAbsoluteFile());
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
			cathitais = AudioSystem.getAudioInputStream(new File("sounds//cathit.wav").getAbsoluteFile());
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
	protected void m2()
	{
		m2.start();
		if(m2.getFrameLength()==m2.getFramePosition())
		{
			m2.setFramePosition(0);
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

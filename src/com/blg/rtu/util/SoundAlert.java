package com.blg.rtu.util;

import java.util.HashMap;

import com.blg.rtu3.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

@SuppressLint("UseSparseArrays")
public class SoundAlert {
	private SoundPool spool;
	private HashMap<Integer, Integer> spMap;
	private float level_1 ;
	private float level_2 ;
	private float level_3 ;
	private float level_4 ;

	public SoundAlert(Context con) {
		spool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
		spMap = new HashMap<Integer, Integer>();
		spMap.put(1, spool.load(con, R.raw.message, 1));
		spMap.put(2, spool.load(con, R.raw.intel, 1));
		spMap.put(3, spool.load(con, R.raw.send, 1));
		spMap.put(4, spool.load(con, R.raw.ding, 1));
		level_1 = 0.5f ;
		level_2 = 0.3f ;
		level_3 = 0.5f ;
		level_4 = 0.5f ;
	}
	
	public void playMessage() {
		playSounds(1, 0, level_1);
	}

	public void playIntel() {
		playSounds(2, 0, level_2);
	}

	public void playSend() {
		playSounds(3, 0, level_3);
	}

	public void playDing() {
		playSounds(4, 0, level_4);
	}

	private void playSounds(int sound, int number, float soundLevel) {
//		AudioManager am = (AudioManager)this.con.getSystemService(Context.AUDIO_SERVICE);
//		float audioMaxVolumn = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
//		float audioCurrentVolumn = am.getStreamVolume(AudioManager.STREAM_MUSIC);
//		float volumnRatio = audioCurrentVolumn / audioMaxVolumn;
//		spool.play(spMap.get(sound), volumnRatio, volumnRatio, 1, number, 1);
		spool.play(spMap.get(sound), soundLevel, soundLevel, 1, number, 1);
	}

}

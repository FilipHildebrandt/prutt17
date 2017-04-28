import sun.awt.image.ImageAccessException;

import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.io.File;

class RPSSkel extends JFrame implements ActionListener{
    Gameboard myboard, computersboard;
    Socket socket;
    BufferedReader in;
    PrintWriter out;
    JButton closebutton;
    JButton muteButton;
    String userHand;
    String serverHand;
    int count;
    boolean mute;
    ImageIcon muteIcon = new ImageIcon("mute.png");



    RPSSkel () {
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	mute = false;
	closebutton = new JButton("Close");
	closebutton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            exit();
        }
    });
	muteButton = new JButton(muteIcon);
	muteButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            mute = !mute;
        }
    });
	myboard = new Gameboard("Myself", this); // Must be changed
	computersboard = new Gameboard("Computer");
	JPanel boards = new JPanel();
	boards.setLayout(new GridLayout(1,2));
	boards.add(myboard);
	boards.add(computersboard);
	add(boards, BorderLayout.CENTER);
	add(closebutton, BorderLayout.SOUTH);
	add(muteButton, BorderLayout.NORTH);
	setSize(300, 550);
	setVisible(true);
	count = 0;
	connect();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        myboard.resetColor();
        computersboard.resetColor();
        count = (count + 1)%3;
        myboard.setUpper(count+"");
        computersboard.setUpper(count+"");


        if(count == 0) {
            userHand = event;
            myboard.markPlayed(event);
            handPlayed();
        }
	}

	private void playSound(String fileName){
        try{
            String soundName = fileName;
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }catch (IOException | UnsupportedAudioFileException | LineUnavailableException error){
            System.out.println(error);
        }
    }

	private void exit(){
        out.println("\u0004");
        out.flush();
        System.exit(0);
    }

	private void handPlayed(){
        getServerHand();
        String audioFile = "";
        computersboard.markPlayed(serverHand);
        String result = compareHands();
        if (result.equals("WIN")){
            myboard.wins();
            myboard.setUpper("WIN!");
            audioFile = "win.wav";
            computersboard.setUpper("LOSE!");
        }else if(result.equals("LOSE")){
            computersboard.wins();
            myboard.setUpper("LOSE!");
            computersboard.setUpper("WIN!");
            audioFile = "lose.wav";
        }else{
            myboard.setUpper("DRAW..");
            computersboard.setUpper("DRAW..");
            audioFile = "tie.wav";
        }
        if (!mute) {
            playSound(audioFile);
        }
    }

	private void getServerHand(){
        try {
            out.println("SAX");
            out.flush();
            serverHand = in.readLine();
        }catch (IOException error){
            System.out.println(error);
        }
	}

	private String compareHands(){

	    if (serverHand.equals(userHand)){
	        return "TIE";
        }
        if (userHand.equals("SAX") && serverHand.equals("STEN") ||
                userHand.equals("PASE") && serverHand.equals("SAX") ||
                userHand.equals("STEN") && serverHand.equals("PASE")){
            return "LOSE";
        }else {
            return "WIN";
        }

    }

	private void connect(){
		try{
			socket = new Socket("share-02.csc.kth.se", 4713);
			in=new BufferedReader
					(new InputStreamReader(socket.getInputStream()));
			out=new PrintWriter(socket.getOutputStream());
			out.println("Charlotta"); out.flush();
            System.out.println(in.readLine());
		}catch (IOException error) {
			System.out.println("Fel vid inläsning");
		}

	}

    public static void main (String[] u) {new RPSSkel();}
}






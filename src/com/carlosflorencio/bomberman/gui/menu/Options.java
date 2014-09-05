package com.carlosflorencio.bomberman.gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSlider;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.carlosflorencio.bomberman.gui.Frame;
import com.carlosflorencio.bomberman.Game;

public class Options extends JMenu implements ChangeListener {

	Frame _frame;
	
	public Options(Frame frame) {
		super("Options");
		
		_frame = frame;
		
		JMenuItem pause = new JMenuItem("Pause");
		pause.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		pause.addActionListener(new MenuActionListener(frame));
		add(pause);
		
		JMenuItem resume = new JMenuItem("Resume");
		resume.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		resume.addActionListener(new MenuActionListener(frame));
		add(resume);
		
		addSeparator();
		
		add(new JLabel("Size: "));
		
		JSlider sizeRange = new JSlider(JSlider.HORIZONTAL,
                1, 5, 3);
		
		//Turn on labels at major tick marks.
		sizeRange.setMajorTickSpacing(2);
		sizeRange.setMinorTickSpacing(1);
		sizeRange.setPaintTicks(true);
		sizeRange.setPaintLabels(true);
		sizeRange.addChangeListener(this);
		
		add(sizeRange);
		
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider)e.getSource();
	    if (!source.getValueIsAdjusting()) {
	        int fps = (int)source.getValue();
	        
	        Game.SCALE = fps;
	        System.out.println( Game.SCALE);
	        
	        _frame._gamepane.changeSize();
			  _frame.revalidate();
			  _frame.pack();
	    }
	}
	
	class MenuActionListener implements ActionListener {
		public Frame _frame;
		public MenuActionListener(Frame frame) {
			_frame = frame;
		}
		
		  @Override
		public void actionPerformed(ActionEvent e) {
			  
			  if(e.getActionCommand().equals("Pause")) {
				  _frame.pauseGame();
			  }
				  
			  if(e.getActionCommand().equals("Resume")) {
				  _frame.resumeGame();
			  }
		  }
	}
}

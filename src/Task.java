import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class Task {
    private JFrame frame;
    protected JTextArea textArea;
    protected JTextField textField;
    private final Object readLineMonitor= new Object();
    private static int MIN_WEIGHT= 800;
    private static int MIN_HEIGHT= 500;
    private static final int FRAME_POSITION_X= 600;
    private static final int FRAME_POSITION_Y= 200;
    public Task(String taskTitle){
        frame= new JFrame(taskTitle);
        frame.setBounds(FRAME_POSITION_X, FRAME_POSITION_Y, frame.getWidth(), frame.getHeight());
        GridBagLayout gbl= new GridBagLayout();
        frame.setLayout(gbl);

        textArea= new JTextArea();
        textField= new JTextField();
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                synchronized (readLineMonitor){
                    readLineMonitor.notifyAll();
                }
            }
        });

        GridBagConstraints gbc= new GridBagConstraints();
        gbc.fill= GridBagConstraints.BOTH;
        gbc.gridheight= 1;
        gbc.gridwidth= 1;
        gbc.gridx= 0;
        gbc.gridy= 0;
        gbc.weightx= 1;
        gbc.weighty= 1;
        gbl.setConstraints(textArea, gbc);

        gbc= new GridBagConstraints();
        gbc.fill= GridBagConstraints.HORIZONTAL;
        gbc.gridheight= 1;
        gbc.gridwidth= 1;
        gbc.gridx= 0;
        gbc.gridy= 1;

        gbc.weightx= 1;
        gbc.weighty= 0;
        gbl.setConstraints(textField, gbc);

        frame.add(textArea);
        frame.add(textField);

        frame.setSize(MIN_WEIGHT,MIN_HEIGHT);
        frame.setMinimumSize(new Dimension(MIN_WEIGHT,MIN_HEIGHT));

        textArea.setEditable(false);
        textField.setEnabled(false);

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        execute();
    }

    public abstract void execute();
    protected String readLine(){
        textField.setEnabled(true);

        synchronized (readLineMonitor){
            try {
                readLineMonitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        textField.setEnabled(false);
        String result= textField.getText();
        textField.setText("");
        return result;
    }
    protected int readInt(){
        boolean correctInput= false;
        int value= -1;
        while(!correctInput){
            try{
                value= Integer.parseInt(readLine());
            }
            catch (NumberFormatException ex){

            }
            if(value >= 1)
                correctInput= true;
            else
                textArea.append("Введено неправильное число, попробуйте ещё раз\n");
        }
        return value;
    }
}



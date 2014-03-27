public class Main {
    public static void main(String... args){
        MainFrame mainFrame= new MainFrame("Java@EPAM task.Task 1");
        mainFrame.setMinimumSize(mainFrame.getPreferredSize());
        mainFrame.setSize(mainFrame.getPreferredSize());
        mainFrame.setVisible(true);
    }
}

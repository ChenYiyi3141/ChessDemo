
    import Music.Music;
    import view.ChessGameFrame;

    import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class Main1 extends JFrame implements ActionListener {
        //定义两个按钮
        private JButton Game_Start;
        private JButton Game_Over;

        public Main1() {
            //定义按钮的排列方式
            setLayout(new FlowLayout());

            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.setSize(300, 200);
            this.setLocation(300, 400);

            Game_Start = new JButton("开始游戏");
            Game_Over = new JButton("结束游戏");
            this.add(Game_Start);
            this.add(Game_Over);
            Game_Start.addActionListener(this);
            Game_Over.addActionListener(this);

            this.setVisible(true);
        }

        public static void main(String[] args) {
            Main1 menu = new Main1();
        }

        /**
         * Invoked when an action occurs.
         *
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == Game_Start) {
                this.dispose();
                SwingUtilities.invokeLater(() -> {
                    ChessGameFrame mainFrame = new ChessGameFrame(1000, 760);

                    mainFrame.setVisible(true);
                    Music musicPlayer = new Music();
                    musicPlayer.play();


                });
            }
            if (e.getSource() == Game_Over) {
                this.dispose();
                System.exit(0);
            }
        }
    }


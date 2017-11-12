package MovingColors;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Paint{
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new draw().setVisible(true);
            }
        });
    }
    
}

class draw extends JFrame{
    private JButton clear;
    private JButton pick;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private canvas jPanel2;
    private JTextField width;
    public draw(){
        super("Moving Squares : Assignment5(B) by IIT2016085");
        initComponents();
    }
    private void initComponents() {

        jPanel1 = new JPanel();
        jPanel1.setBackground(new Color(161, 228, 213));
        clear = new JButton();
        pick = new JButton();
        width = new JTextField();
        jLabel1 = new JLabel();
        jPanel2 = new canvas();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        clear.setText("Clear");
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        pick.setText("Pick Color");
        pick.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                pickActionPerformed(evt);
            }
        });
        width.setText("Width");
        width.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                widthActionPerformed(evt);
            }
        });
        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel1.setText("Width Of rectangle");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(width, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(53, 53, 53)
                                                .addComponent(pick, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 326, Short.MAX_VALUE)
                                .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(width, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(pick, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 386, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }
    private void clearActionPerformed(ActionEvent evt) {
        jPanel2.clear();
    }
    private void pickActionPerformed(ActionEvent evt) {
        jPanel2.setcolor(JColorChooser.showDialog(this,"Select a color", Color.WHITE));
    }
    private void widthActionPerformed(ActionEvent evt){
        String tmp = width.getText();
        for(int i = 0; i < tmp.length(); ++i){
            if(tmp.charAt(i) < '0' || tmp.charAt(i) > '9'){
                JOptionPane.showMessageDialog(this, "Enter a number", "Inane error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        jPanel2.setwidth(Integer.parseInt(tmp));
    }
}

class canvas extends JPanel{
    ArrayList <rect> comp;
    int width;
    canvas t;
    Color color;
    public canvas(){
        this.width = 25;
        this.color = Color.GRAY;
        this.comp = new ArrayList<rect>();
        this.setBackground(Color.WHITE);
        t = this;
        this.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                Drawrect(e);
            }
        });
        this.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                moverect(e);
            }
        });
    }
    private void Drawrect(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        comp .add(new rect(x, y, width, color));
        t.setFocusable(true);
        t.requestFocusInWindow();
        repaint();
    }
    public void moverect(KeyEvent e){
        int code = e.getKeyCode();
        if(code == 37){
            //left
            rect last = comp.get(comp.size()-1);
            int left = 0;
            if(last.getx() - last.getwidth() / 2 >= left){
                rect r = new rect(last.getx() - 3, last.gety(), last.getwidth(), last.getcolor());
                comp.remove(comp.size()-1);
                comp.add(r);
            }
        }
        else if(code == 38){
            //up
            rect last = comp.get(comp.size() - 1);
            int up = 0;
            if(last.gety() - last.getwidth() / 2 >= up){
                rect r = new rect(last.getx(), last.gety() - 3, last.getwidth(), last.getcolor());
                comp.remove(comp.size() - 1);
                comp.add(r);
            }
        }
        else if(code == 39){
            //right
            rect last = comp.get(comp.size() - 1);
            int right = getWidth();
            if(last.getx() + last.getwidth() / 2 <= right){
                rect r = new rect(last.getx() + 3, last.gety(), last.getwidth(), last.getcolor());
                comp.remove(comp.size() - 1);
                comp.add(r);
            }
        }
        else if(code == 40){
            //down
            int down = getHeight();
            rect last = comp.get(comp.size() - 1);
            if(last.gety() + last.getwidth() / 2 <= down){
                rect r = new rect(last.getx(), last.gety() + 3, last.getwidth(), last.getcolor());
                comp.remove(comp.size() - 1);
                comp.add(r);
            }
        }
        repaint();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < comp.size(); ++i){
            g.setColor(comp.get(i).getcolor());
            int x = comp.get(i).getx();
            int y = comp.get(i).gety();
            int width = comp.get(i).getwidth();
            g.fillRect(x- width / 2, y - width / 2, width, width);
        }
    }
    void setwidth(int width){
        this.width = width;
    }
    void setcolor(Color color){
        this.color = color;
    }
    void clear(){
        comp.clear();
        repaint();
    }
}

class rect{
    private int x, y, width;
    private Color color;
    public rect(int x, int y, int width, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
        this.width = width;
    }
    public int getx(){
        return x;
    }
    public int gety(){
        return y;
    }
    public int getwidth(){
        return width;
    }
    public Color getcolor(){
        return color;
    }
}
package xw.daily.secondday;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Player extends KeyAdapter {

   // HeroPlan heroPlan ;
    GameFrame gameFrame ;

    public Player(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    public Player() {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        //System.out.println(keyCode);
        //38 40 37 39
        switch (keyCode){
            case 38: gameFrame.heroPlan.up = true ;
            break;
            case 40: gameFrame.heroPlan.down = true ;
                break;
            case 37: gameFrame.heroPlan.left = true ;
                break;
            case 39:gameFrame. heroPlan.right = true ;
                break;
         /*   case 32: addBullet();
                break;*/
        }
        if(keyCode==32){
            addBullet();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        System.out.println(keyCode);
        //38 40 37 39
        switch (keyCode){
            case 38: gameFrame.heroPlan.up = false ;
                break;
            case 40: gameFrame.heroPlan.down = false ;
                break;
            case 37: gameFrame.heroPlan.left = false ;
                break;
            case 39: gameFrame.heroPlan.right = false ;
                break;
        }

    }

    public void addBullet(){
        Bullet bullet = new Bullet(gameFrame.heroPlan.x+3,gameFrame.heroPlan.y-10);
        gameFrame.bullets.add(bullet);
    }

}

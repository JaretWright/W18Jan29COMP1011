/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w18comp1011jan29;

/**
 *
 * @author JWright
 */
public class monsterHunter {
    private String hunter, monster;

    public monsterHunter(String hunter, String monster) {
        this.hunter = hunter;
        this.monster = monster;
    }

    public String getHunter() {
        return hunter;
    }

    public void setHunter(String hunter) {
        this.hunter = hunter;
    }

    public String getMonster() {
        return monster;
    }

    public void setMonster(String monster) {
        this.monster = monster;
    }
    
    
    
    public void forLoopExample()
    {
        double[] grades = {51, 100, 99, 98};
        for (double  info:grades)
        {
            System.out.println(info);
        }
    }
    
    public static String coolMethod()
    {
        return "Attack";
    }
}

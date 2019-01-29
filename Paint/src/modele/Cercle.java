/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author user
 */
public class Cercle extends Forme {
    
    /**
     * Point situé en haut à gauche du cercle.
     */
    private Point pHautGauche;

    private int diametre;
    
    /**
     * Constructeur par données de la classe Cercle.
     * Si un point vaut null, alors le point en question sera remplacé par un point de coordonnées (0,0).
     * Le diamètre est la distance entre pDebut et pFinal.
     * @param pDebut Point représentant l'appui sur la souris pour dessiner.    
     * @param pFinal Point représentant le relachement de la souris. 
     * @param couleurForme La couleur du dessin.
     */
    public Cercle( Color couleurForme,Point pDebut, Point pFinal) 
    {
        super(couleurForme);
        if( pDebut == null)
        {
            pDebut = new Point(0,0);
        }
        if( pFinal == null)
        {
            pFinal = new Point(0,0);
        }
       
        int diffX = pFinal.getX() - pDebut.getX();
        int diffY = pFinal.getY() - pDebut.getY();
        
        this.diametre = Math.min( Math.abs(diffX) , Math.abs(diffY) );

        
        int x = pDebut.getX();
        int y = pDebut.getY();
        
        if( diffX < 0)
            x = x - this.diametre;
        if( diffY < 0)
            y = y - this.diametre;
        
        this.pHautGauche = new Point(x,y);
            
        
        
        
    }
    
    
    @Override
    public void seDessiner(Graphics g)
    {
        super.seDessiner(g);

        g.drawOval(this.pHautGauche.getX() , this.pHautGauche.getY(), diametre, diametre);
    }
    
    
    
}

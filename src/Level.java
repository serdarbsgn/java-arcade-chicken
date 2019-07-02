import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Level extends JPanel{
	protected int resolutionx,resolutiony;
	protected Player player1 ;
	protected CatYellow[] catyellow;
	protected int yellow;
	protected CatBlack[] catblack;
	protected int black;
	protected CatBoss[] catboss;
	protected int boss;
	protected Egg egg1;
	protected ObjectsToHit obj1 = new ObjectsToHit(resolutionx);
	protected BackGround background;
	protected boolean starsorclouds;
	protected MeteorBlue[] meteorb;
	protected MeteorYellow[] meteory;
	protected PlaneLeft[] planel;
	protected PlaneRight[] planer;
	protected Sounds sounds = new Sounds();
	
	public Level(int ayellow,int ablack,int aboss,boolean astarsorclouds,int aresolutionx,int aresolutiony)
	{
		resolutionx=aresolutionx;
		resolutiony=aresolutiony;
		player1 = new Player(resolutionx,resolutiony);
		egg1 = new Egg(player1.playerX,player1.playerY);
		background = new BackGround(resolutionx,resolutiony);
		yellow=ayellow;
		catyellow = new CatYellow[yellow];
		black=ablack;
		catblack = new CatBlack[black];
		boss=aboss;
		catboss = new CatBoss[boss];
		starsorclouds=astarsorclouds;
		for(int i=0 ; i < yellow;i++)
		{
			catyellow[i] = new CatYellow(resolutionx,resolutiony);
		}
		for(int i=0;i < black;i++)
		{
			catblack[i]  = new CatBlack(resolutionx,resolutiony);
			catblack[i].catYV+=i;
		}
		for(int i=0; i < boss;i++)
		{
			catboss[i]   = new CatBoss(resolutionx,resolutiony);
		}
		if(starsorclouds)
		{
			meteory= new MeteorYellow[2];
			meteorb=new MeteorBlue[2];
			for(int i=0;i < 2;i++)
			{
				meteory[i]=new MeteorYellow();
				meteorb[i]=new MeteorBlue();
			}
		}
		else
		{
			planer=new PlaneRight[2];
			planel=new PlaneLeft[2];
			for(int i=0;i < 2;i++)
			{
				planer[i]=new PlaneRight();
				planel[i]=new PlaneLeft();
			}
		}	
	}
	
	public void paint(Graphics g)
	{
		if(starsorclouds)
		{		//looping stars
				g.drawImage(BackGround.backgroundstar, 0, BackGround.backgroundY, resolutionx, resolutiony, null);
				g.drawImage(BackGround.backgroundstar, 0, BackGround.backgroundY2, resolutionx, resolutiony, null);
				
				//moon
				g.drawImage(BackGround.moon, 200, BackGround.moonY, 383, 383, null);
				g.drawImage(BackGround.iss, 500, BackGround.issY, 383, 153, null);
				//blue meteors
				g.drawImage(MeteorBlue.meteorblue,	meteorb[0].MeteorX, meteorb[0].MeteorY,(int)(resolutionx/6.4),(int)(resolutionx/6.4), null);
				g.drawImage(MeteorBlue.meteorblue,	-meteorb[1].MeteorX, meteorb[1].MeteorY,-(int)(resolutionx/6.4),(int)(resolutionx/6.4), null);

				//yellow meteors
				g.drawImage(MeteorYellow.meteoryellow, meteory[0].MeteorX, meteory[0].MeteorY,(int)(resolutionx/6.4),(int)(resolutionx/6.4), null);
				g.drawImage(MeteorYellow.meteoryellow, -meteory[1].MeteorX, meteory[1].MeteorY,-(int)(resolutionx/6.4),(int)(resolutionx/6.4), null);
		}
		else
		{
			//looping clouds
				g.drawImage(BackGround.backgroundcloud, 0, BackGround.backgroundY, resolutionx, resolutiony, null);
				g.drawImage(BackGround.backgroundcloud, 0, BackGround.backgroundY2, resolutionx, resolutiony, null);
			//planes
				g.drawImage(PlaneLeft.planeleft, planel[0].planeX, planel[0].planeY,(int)(resolutionx/7.8),(int)(resolutionx/12.8), null);
				g.drawImage(PlaneRight.planeright, planer[0].planeX, planer[0].planeY,-(int)(resolutionx/6.4),(int)(resolutionx/21), null);
				g.drawImage(PlaneLeft.planeleft, -planel[1].planeX, planel[1].planeY,-(int)(resolutionx/7.8),(int)(resolutionx/12.8), null);
				g.drawImage(PlaneRight.planeright, -planer[1].planeX, planer[1].planeY,(int)(resolutionx/6.4),(int)(resolutionx/21), null);
		}
		
		//changing chicken pictures
		if(player1.playerRight)
		{	
				g.drawImage(Player.chickenright, player1.playerX, player1.playerY,(int)(resolutionx/6.4) ,(int)(resolutionx/6), null);
		}
		else
		{
				g.drawImage(Player.chickenleft, player1.playerX, player1.playerY,(int)(resolutionx/6.4) ,(int)(resolutionx/6), null);
		}	
		
				//throwing egg
				if(egg1.throwaegg)
				{
					g.drawImage(egg1.egg, egg1.eggX, egg1.eggY,(int)(resolutionx/64),(int)(resolutionx/48), null);
				}
				
				g.setColor(Color.WHITE);
				g.fillRect(obj1.ObjectX, obj1.ObjectY, obj1.ObjectWidth, obj1.ObjectHeight);
				
				//changing cat pictures
				for(int i=0 ; i < yellow ; i++)
				{
					if(catyellow[i].catgoestoright)
					{
						if(catyellow[i].catattack)
						{
							g.drawImage(CatYellow.catrightattack, catyellow[i].catX, catyellow[i].catY,(int)(resolutionx/6.4),(int)(resolutionx/6.4),null);
						}
						else
						{
							g.drawImage(CatYellow.catright, catyellow[i].catX, catyellow[i].catY,(int)(resolutionx/6.4) ,(int)(resolutionx/6.4),null);
						}
					}
					else
					{
						if(catyellow[i].catattack)
						{
							g.drawImage(CatYellow.catleftattack, catyellow[i].catX, catyellow[i].catY,(int)(resolutionx/6.4) ,(int)(resolutionx/6.4),null);
						}
						else
						{
							g.drawImage(CatYellow.catleft, catyellow[i].catX, catyellow[i].catY,(int)(resolutionx/6.4) ,(int)(resolutionx/6.4),null);
						}	
					}	
				}
				
				for(int i=0 ; i < black ; i++)
				{
					if(catblack[i].catgoestoright)
					{
						if(catblack[i].catattack)
						{
							g.drawImage(CatBlack.blackcatrightattack, catblack[i].catX, catblack[i].catY,(int)(resolutionx/6.4) ,(int)(resolutionx/6.4),null);
						}
						else
						{
							g.drawImage(CatBlack.blackcatright, catblack[i].catX, catblack[i].catY,(int)(resolutionx/6.4) ,(int)(resolutionx/6.4),null);
						}
					}
					else
					{
						if(catblack[i].catattack)
						{
							g.drawImage(CatBlack.blackcatleftattack, catblack[i].catX, catblack[i].catY,(int)(resolutionx/6.4) ,(int)(resolutionx/6.4),null);
						}
						else
						{
							g.drawImage(CatBlack.blackcatleft, catblack[i].catX, catblack[i].catY,(int)(resolutionx/6.4) ,(int)(resolutionx/6.4),null);
						}	
					}	
				}	
				
				for(int i=0 ; i < boss ; i++)
				{
					if(catboss[i].catgoestoright)
					{
						if(catboss[i].catattack)
						{
							g.drawImage(CatBoss.bosscatrightattack, catboss[i].catX, catboss[i].catY,(int)(resolutionx/6.4) ,(int)(resolutionx/6.4),null);
						}
						else
						{
							g.drawImage(CatBoss.bosscatright, catboss[i].catX, catboss[i].catY,(int)(resolutionx/6.4) ,(int)(resolutionx/6.4),null);
						}
					}
					else
					{
						if(catboss[i].catattack)
						{
							g.drawImage(CatBoss.bosscatleftattack, catboss[i].catX, catboss[i].catY,(int)(resolutionx/6.4) ,(int)(resolutionx/6.4),null);
						}
						else
						{
							g.drawImage(CatBoss.bosscatleft, catboss[i].catX, catboss[i].catY,(int)(resolutionx/6.4) ,(int)(resolutionx/6.4),null);
						}	
					}	
				}
				
				Font f = new Font("Comic Sans MS",Font.BOLD,(int)(resolutionx/38.4));
				g.setFont (f);
				g.drawString("Score = " + String.valueOf(player1.score) +  "        Health = " + String.valueOf(player1.health), (int)((resolutionx/3)), 40);
	}
	

	public void level()
	{
	
		if(obj1.ObjectY<-299)
		{
			player1.score=player1.score-11+obj1.ObjectSpeed;
			obj1 = new ObjectsToHit(resolutionx);
		}
		if(new Rectangle(egg1.eggX, egg1.eggY,(int)(resolutionx/64),(int)(resolutionx/48)).intersects(new Rectangle(obj1.ObjectX,obj1.ObjectY,obj1.ObjectWidth,obj1.ObjectHeight)))
			{
				sounds.score();
				player1.score=player1.score + 10*(obj1.ObjectSpeed);
				obj1 = new ObjectsToHit(resolutionx) ;                                                             
			}
		if(starsorclouds)
		{
			for(int i=0;i<2;i++)
			{	
			meteory[i].MeteorMovement();
			meteorb[i].MeteorMovement();
			}
			
		}
		else
		{
			for(int i=0;i<2;i++)
			{	
			planel[i].PlaneMovement();
			planer[i].PlaneMovement();
			}
			
		}
		obj1.ObjectY-=obj1.ObjectSpeed;
		player1.PlayerMovement(resolutionx,resolutiony);
		//code about egg movement
		egg1.EggMovement(player1.playerX, player1.playerY, player1.playerRight,resolutionx,resolutiony);
				
		//code about cat
		for(int i =0; i<yellow;i++)
		{
			player1.health=catyellow[i].CatMovement(player1.playerY, player1.playerX, egg1.eggY, egg1.eggX,player1.health, egg1.throwaegg);
		}
		for(int i =0; i<black;i++)
		{
			player1.health=catblack[i].CatMovement(player1.playerY, player1.playerX, egg1.eggY, egg1.eggX,player1.health, egg1.throwaegg);
		}
		for(int i =0; i<boss;i++)
		{
			player1.health=catboss[i].CatMovement(player1.playerY, player1.playerX, egg1.eggY, egg1.eggX,player1.health, egg1.throwaegg);
		}
		
		//code about background
		BackGround.Movement();
	}
}



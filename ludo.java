import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
class Abc extends JFrame implements MouseListener
{
	Game ga=new Game();
	Path pr,py,temp,node;
	Vector v=new Vector();
	Font f=new Font("Arial",Font.BOLD,25);
	Font f1=new Font("Arial",Font.BOLD,45);

	//backgroung image
	Image bck=new ImageIcon("bck.png").getImage();
	//ludo image
	Image l1=new ImageIcon("1.png").getImage();
	Image l2=new ImageIcon("2.png").getImage();
	Image l3=new ImageIcon("3.png").getImage();
	Image l4=new ImageIcon("4.png").getImage();
	Image l5=new ImageIcon("5.png").getImage();
	Image l6=new ImageIcon("6.png").getImage();
	//red 
	int r1_x,r1_y,r2_x,r2_y,r3_x,r3_y,r4_x,r4_y;
	Image r1=new ImageIcon("red.png").getImage();
	Image r2=new ImageIcon("red.png").getImage();
	Image r3=new ImageIcon("red.png").getImage();
	Image r4=new ImageIcon("red.png").getImage();
	//yellow
	int y1_x,y1_y,y2_x,y2_y,y3_x,y3_y,y4_x,y4_y;
	Image y1=new ImageIcon("yellow.png").getImage();
	Image y2=new ImageIcon("yellow.png").getImage();
	Image y3=new ImageIcon("yellow.png").getImage();
	Image y4=new ImageIcon("yellow.png").getImage();
	//player 1:
		int mr1=0,mr2=0,mr3=0,mr4=0;
		int player1=0;
	//player 2:
		int my1=0,my2=0,my3=0,my4=0;
		int player2=0;
	//chance
		int red=0,yellow=0;;
		int p1=0,p2=0,temp1=1,temp2=1;
		int mp1=1,mp2=1;
		int start=1;
		Image get_img;
		int chance=0,move=0;
	public Abc()
	{
		//path initilization of red and yellow goti
		pr=ga.redinit();
		py=ga.yellowInit();
		setVisible(true);
		setSize(1200,1100);
		setTitle("Game Design By Vikash Sinha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseListener(this);
		//add image in vecotor
		v.addElement(l1);
		v.addElement(l2);
		v.addElement(l3);
		v.addElement(l4);
		v.addElement(l5);
		v.addElement(l6);
		//initilization of red goti
		r1_x=340; r1_y=260;
		r2_x=280;r2_y=320;
		r3_x=400;r3_y=320;
		r4_x=340;r4_y=380;
		//initilization of yellow goti
		y1_x=830;y1_y=750;
		y2_x=750;y2_y=820;
		y3_x=890;y3_y=820;
		y4_x=830;y4_y=870;
	}
	public void paint(Graphics g)
	{
		g.fillRect(0,0,1200,1200);
		g.setColor(Color.red);
		g.fillRect(70,250,100,100);
		g.setColor(Color.YELLOW);
		g.fillRect(1040,800,100,100);
		g.drawImage(bck,200,200,800,800,null);
		
		// Draw red goti
		g.drawImage(r1,r1_x,r1_y,40,40,null); 
		g.drawImage(r2,r2_x,r2_y,40,40,null); 
		g.drawImage(r3,r3_x,r3_y,40,40,null); 
		g.drawImage(r4,r4_x,r4_y,40,40,null); 

		//draw yellow
		g.drawImage(y1,y1_x,y1_y,40,40,null);
		g.drawImage(y2,y2_x,y2_y,40,40,null);
		g.drawImage(y3,y3_x,y3_y,40,40,null);
		g.drawImage(y4,y4_x,y4_y,40,40,null);
		
		//g.setColor(Color.WHITE);
		g.setFont(f);
		if(player1==1&&mp1==1)
		{
				for(int j=0;j<5;j++)
				{
					
					g.drawImage((Image)v.elementAt(j),80,260,80,80,null);
					try{Thread.sleep(200);}catch(Exception e){}
				}
				g.setColor(Color.BLACK);
				g.drawImage(get_img,80,260,80,80,null);
				mp1=0;
				if(move==6)
					g.drawString("Click",80,300);
				else
					g.drawString("Click",1050,850);
			
		}
		if(player2==1&&mp2==1)
		{
				for(int j=0;j<5;j++)
				{
					
					g.drawImage((Image)v.elementAt(j),1050,810,80,80,null);
					try{Thread.sleep(200);}catch(Exception e){}
				}
				
				g.drawImage(get_img,1050,810,80,80,null);
			
			mp2=0;
			g.setColor(Color.BLACK);
			if(move==6)
				g.drawString("Click",1050,850);
			else
				g.drawString("Click",80,300);
				mp1=0;
		}


		//WIN STATEMENT
		if(mr1>56&&mr2>56&&mr3>56&&mr4>56)
		{
			g.setColor(Color.RED);
			g.drawString("RED PLAYER WIN THIS GAME",300,500);
		}
		if(my1>56&&my2>56&&my3>56&&my4>56)
		{
			g.setColor(Color.YELLOW);
			g.drawString("YELLOW PLAYER WIN THIS GAME",300,500);
		}


		//EXCUTE WHEN STAR GAME
		if(start==1)
		{
			g.setColor(Color.RED);
			g.drawString("START",1050,850);
	
		}

	}
	public void mouseClicked(MouseEvent m)
	{
		
		int x,y,click_goti;
		String l_img;
		Path p;
		x=m.getX();
		y=m.getY();
		if(move!=0&&p1==1)
		{
			
			if(x>r1_x&&x<r1_x+40&&y>r1_y&&y<r1_y+40)
			{
				if(move==1)
					red=0;
				if(mr1==0&&move==6)
				{
					r1_x=270;
					r1_y=530;
					mr1=1;
					
				}
				else if(mr1>0)
				{
					red=1;		
					mr1=move+mr1;
					p=ga.position(pr,mr1);
					r1_x=p.x;
					r1_y=p.y;
					if(new Rectangle(r1_x,r1_y,40,40).intersects(new Rectangle(y1_x,y1_y,40,40))
)
					{
						if(my1!=1&&my1!=13&&my1!=26&&my1!=39)
						{
							y1_x=830;y1_y=750;
							my1=0;chance=1;
						}
					}
					else if(new Rectangle(r1_x,r1_y,40,40).intersects(new Rectangle(y2_x,y2_y,40,40))
)
					{
						if(my2!=1&&my2!=13&&my2!=26&&my2!=39)
						{
							y2_x=750;y2_y=820;
							my2=0;chance=1;
						}
					}
					else if(new Rectangle(r1_x,r1_y,40,40).intersects(new Rectangle(y3_x,y3_y,40,40))
)
					{
						if(my3!=1&&my3!=13&&my3!=26&&my3!=39)
						{
							y3_x=890;y3_y=820;
							my3=0;chance=1;
						}
					}
					else if(new Rectangle(r1_x,r1_y,40,40).intersects(new Rectangle(y4_x,y4_y,40,40))
)
					{
						if(my4!=1&&my4!=13&&my4!=26&&my4!=39)
						{
							y4_x=830;y4_y=870;
							my4=0;
							chance=1;
						}
					}
				}
				
				repaint();
				
			}
			else if(x>r2_x&&x<r2_x+40&&y>r2_y&&y<r2_y+40)
			{
				if(move==1)
					red=0;
				if(mr2==0&&move==6)
				{
					r2_x=275;
					r2_y=535;
					mr2=1;
				
				}
				else if(mr2>0)
				{
					red=1;
					mr2=move+mr2;
					p=ga.position(pr,mr2);
					r2_x=p.x;
					r2_y=p.y;
					if(new Rectangle(r2_x,r2_y,40,40).intersects(new Rectangle(y1_x,y1_y,40,40))
)
					{
						if(my1!=1&&my1!=13&&my1!=26&&my1!=39)
						{
							y1_x=830;y1_y=750;
							my1=0;
							chance=1;
						}
					}
					else if(new Rectangle(r2_x,r2_y,40,40).intersects(new Rectangle(y2_x,y2_y,40,40))
)
					{
						if(my2!=1&&my2!=13&&my2!=26&&my2!=39)
						{
							y2_x=750;y2_y=820;
							my2=0;
							chance=1;
						}

					}
					else if(new Rectangle(r2_x,r2_y,40,40).intersects(new Rectangle(y3_x,y3_y,40,40))
)
					{
						if(my3!=1&&my3!=13&&my3!=26&&my3!=39)
						{
							y3_x=890;y3_y=820;
							my3=0;
							chance=1;
						}
					}
					else if(new Rectangle(r2_x,r2_y,40,40).intersects(new Rectangle(y4_x,y4_y,40,40))
)
					{
						if(my4!=1&&my4!=13&&my4!=26&&my4!=39)
						{
							y4_x=830;y4_y=870;
							my4=0;
							chance=1;
						}
					}
				
				}
				repaint();
				
			}
			else if(x>r3_x&&x<r3_x+40&&y>r3_y&&y<r3_y+40)
			{
				if(move==1)
					red=0;
				if(mr3==0&&move==6)
				{
					r3_x=265;
					r3_y=530;
					mr3=1;
					
				}
				else if(mr3>0)
				{
					red=1;
					mr3=move+mr3;
					p=ga.position(pr,mr3);
					r3_x=p.x;
					r3_y=p.y;
					if(new Rectangle(r3_x,r3_y,40,40).intersects(new Rectangle(y1_x,y1_y,40,40))
)
					{
						if(my1!=1&&my1!=13&&my1!=26&&my1!=39)
						{
							y1_x=830;y1_y=750;
							my1=0;
							chance=1;
						}
					}
					else if(new Rectangle(r3_x,r3_y,40,40).intersects(new Rectangle(y2_x,y2_y,40,40))
)
					{
						if(my2!=1&&my2!=13&&my2!=26&&my2!=39)
						{
							y2_x=750;y2_y=820;
							my2=0;
							chance=1;
						}

					}
					else if(new Rectangle(r3_x,r3_y,40,40).intersects(new Rectangle(y3_x,y3_y,40,40))
)
					{
						if(my3!=1&&my3!=13&&my3!=26&&my3!=39)
						{
							y3_x=890;y3_y=820;
							my3=0;
							chance=1;
						}
					}
					else if(new Rectangle(r4_x,r4_y,40,40).intersects(new Rectangle(y4_x,y4_y,40,40))
)
					{
						if(my4!=1&&my4!=13&&my4!=26&&my4!=39)
						{
							y4_x=830;y4_y=870;
							my4=0;
							chance=1;
						}
					}

				}
				
				repaint();
				
			}
			else if(x>r4_x&&x<r4_x+40&&y>r4_y&&y<r4_y+40)
			{
				if(move==1)
					red=0;
				if(mr4==0&&move==6)
				{
					r4_x=260;
					r4_y=525;
					mr4=1;
				
					
				}
				else if(mr4>0)
				{
					red=1;
					mr4=move+mr4;
					p=ga.position(pr,mr4);
					r4_x=p.x;
					r4_y=p.y;
					if(new Rectangle(r4_x,r4_y,40,40).intersects(new Rectangle(y1_x,y1_y,40,40))
)
					{
						if(my1!=1&&my1!=13&&my1!=26&&my1!=39)
						{
							y1_x=830;y1_y=750;
							my1=0;
							chance=1;
						}
					}
					else if(new Rectangle(r4_x,r4_y,40,40).intersects(new Rectangle(y2_x,y2_y,40,40))
)
					{
						if(my2!=1&&my2!=13&&my2!=26&&my2!=39)
						{
							y2_x=750;y2_y=820;
							my2=0;
							chance=1;
						}

					}
					else if(new Rectangle(r4_x,r4_y,40,40).intersects(new Rectangle(y3_x,y3_y,40,40))
)
					{
						if(my3!=1&&my3!=13&&my3!=26&&my3!=39)
						{
							y3_x=890;y3_y=820;
							my3=0;
							chance=1;
						}
					}
					else if(new Rectangle(r4_x,r4_y,40,40).intersects(new Rectangle(y4_x,y4_y,40,40))
)
					{
						if(my4!=1&&my4!=13&&my4!=26&&my4!=39)
						{
							y4_x=830;y4_y=870;
							my4=0;
							chance=1;
						}
					}
				}
				
				repaint();
				
			}
			move=0;
		}
		if(move!=0&&p2==1)
		{
			

				if(x>y1_x&&x<y1_x+40&&y>y1_y&&y<y1_y+40)
				{
					if(move==6)
						yellow=0;
					if(my1==0&&move==6)
					{
						y1_x=890;
						y1_y=635;
						my1=1;
						
					}
					else if(my1>0)
					{
						yellow=1;
						my1=move+my1;
						p=ga.position(py,my1);
						y1_x=p.x;
						y1_y=p.y;
						if(new Rectangle(r1_x,r1_y,40,40).intersects(new Rectangle(y1_x,y1_y,40,40)))
						{
							if(mr1!=1&&mr1!=13&&mr1!=26&&mr1!=39)
							{
								r1_x=340; r1_y=260;
								mr1=0;
								chance=0;
							}
						}
						else if(new Rectangle(r2_x,r2_y,40,40).intersects(new Rectangle(y1_x,y1_y,40,40)))
						{
							if(mr2!=1&&mr2!=13&&mr2!=26&&mr2!=39)
							{
								r2_x=340; r2_y=260;
								mr2=0;
								chance=0;
							}
						}
						else if(new Rectangle(r3_x,r3_y,40,40).intersects(new Rectangle(y1_x,y1_y,40,40)))
						{
							if(mr3!=1&&mr3!=13&&mr3!=26&&mr3!=39)
							{
								r3_x=400;r3_y=320;
								mr3=0;
								chance=0;
							}
						}
						else if(new Rectangle(r4_x,r4_y,40,40).intersects(new Rectangle(y1_x,y1_y,40,40)))
						{
							if(mr4!=1&&mr4!=13&&mr4!=26&&mr4!=39)
							{
								r4_x=340;r4_y=380;
								mr4=0;
								chance=0;
							}
						}
					}
					
					repaint();
					
				}
				else if(x>y2_x&&x<y2_x+40&&y>y2_y&&y<y2_y+40)
				{
					if(move==6)
						yellow=0;
					if(my2==0&&move==6)
					{
						y2_x=887;
						y2_y=640;
						my2=1;
						
					}
					else if(my2>0)
					{
						yellow=1;
						my2=move+my2;
						p=ga.position(py,my2);
						y2_x=p.x;
						y2_y=p.y;
					if(new Rectangle(r1_x,r1_y,40,40).intersects(new Rectangle(y2_x,y2_y,40,40)))
						{
							if(mr1!=1&&mr1!=13&&mr1!=26&&mr1!=39)
							{
								r1_x=340; r1_y=260;
								mr1=0;
								chance=0;
							}
						}
						else if(new Rectangle(r2_x,r2_y,40,40).intersects(new Rectangle(y2_x,y2_y,40,40)))
						{
							if(mr2!=1&&mr2!=13&&mr2!=26&&mr2!=39)
							{
								r2_x=340; r2_y=260;
								mr2=0;
								chance=0;
							}
						}
						else if(new Rectangle(r3_x,r3_y,40,40).intersects(new Rectangle(y2_x,y2_y,40,40)))
						{
							if(mr3!=1&&mr3!=13&&mr3!=26&&mr3!=39)
							{
								r3_x=400;r3_y=320;
								mr3=0;
								chance=0;
							}
						}
						else if(new Rectangle(r4_x,r4_y,40,40).intersects(new Rectangle(y2_x,y2_y,40,40)))
						{
							if(mr4!=1&&mr4!=13&&mr4!=26&&mr4!=39)
							{
								r4_x=340;r4_y=380;
								mr4=0;
								chance=0;
							}
						}
					}
					
					repaint();
					
				}
				else if(x>y3_x&&x<y3_x+40&&y>y3_y&&y<y3_y+40)
				{
					if(move==6)
						yellow=0;
					if(my3==0&&move==6)
					{
						y3_x=895;
						y3_y=640;
						my3=1;
					}
					else if(my3>0)
					{
						yellow=1;
						my3=move+my3;
						p=ga.position(py,my3);
						y3_x=p.x;
						y3_y=p.y;
						if(new Rectangle(r1_x,r1_y,40,40).intersects(new Rectangle(y3_x,y3_y,40,40)))
						{
							if(mr1!=1&&mr1!=13&&mr1!=26&&mr1!=39)
							{
								r1_x=340; r1_y=260;
								mr1=0;
								chance=0;
							}
						}
						else if(new Rectangle(r2_x,r2_y,40,40).intersects(new Rectangle(y3_x,y3_y,40,40)))
						{
							if(mr2!=1&&mr2!=13&&mr2!=26&&mr2!=39)
							{
								r2_x=340; r2_y=260;
								mr2=0;
								chance=0;
							}
						}
						else if(new Rectangle(r3_x,r3_y,40,40).intersects(new Rectangle(y3_x,y3_y,40,40)))
						{
							if(mr3!=1&&mr3!=13&&mr3!=26&&mr3!=39)
							{
								r3_x=400;r3_y=320;
								mr3=0;
								chance=0;
							}
						}
						else if(new Rectangle(r4_x,r4_y,40,40).intersects(new Rectangle(y3_x,y3_y,40,40)))
						{
							if(mr4!=1&&mr4!=13&&mr4!=26&&mr4!=39)
							{
								r4_x=340;r4_y=380;
								mr4=0;
								chance=0;
							}
						}
					}
					
					repaint();
					
				}
				else if(x>y4_x&&x<y4_x+40&&y>y4_y&&y<y4_y+40)
				{
					if(move==6)
						yellow=0;
					if(my4==0&&move==6)
					{
						y4_x=890;
						y4_y=635;
						my4=1;
					}
					else if(my4>0)
					{
						yellow=1;
						my4=move+my4;
						p=ga.position(py,my4);
						y4_x=p.x;
						y4_y=p.y;
						if(new Rectangle(r1_x,r1_y,40,40).intersects(new Rectangle(y4_x,y4_y,40,40)))
						{
							if(mr1!=1&&mr1!=13&&mr1!=26&&mr1!=39)
							{
								r1_x=340; r1_y=260;
								mr1=0;
								chance=0;
							}
						}
						else if(new Rectangle(r2_x,r2_y,40,40).intersects(new Rectangle(y4_x,y4_y,40,40)))
						{
							if(mr2!=1&&mr2!=13&&mr2!=26&&mr2!=39)
							{
								r2_x=340; r2_y=260;
								mr2=0;
								chance=0;
							}
						}
						else if(new Rectangle(r3_x,r3_y,40,40).intersects(new Rectangle(y4_x,y4_y,40,40)))
						{
							if(mr3!=1&&mr3!=13&&mr3!=26&&mr3!=39)
							{
								r3_x=400;r3_y=320;
								mr3=0;
								chance=0;
							}
						}
						else if(new Rectangle(r4_x,r4_y,40,40).intersects(new Rectangle(y4_x,y4_y,40,40)))
						{
							if(mr4!=1&&mr4!=13&&mr4!=26&&mr4!=39)
							{
								r4_x=340;r4_y=380;
								mr4=0;
								chance=0;
							}
						}
					}
					
					repaint();
					
				}
			move=0;
		}

		
		if(x>70&&x<170&&y>250&&y<350&&chance==1)
		{

			move=ga.rand();	
			get_img=(Image)v.elementAt(move-1);
			if(move==6)
			{

			
				chance=1;
			}
			else
			{
				chance=0;
				player1=1;
				player2=0;
			}
			player1=1;
			player2=0;
			p1=1;
			p2=0;
			
			mp1=1;
			repaint();
			
			

		}
		else if(x>1040&&x<1140&&y>800&&y<900&&chance==0)
		{
			start=0;
			move=ga.rand();	
			get_img=(Image)v.elementAt(move-1);
			p1=0;
			p2=1;
			if(move==6)
			{
				
				chance=0;
			}
			else
			{
				chance=1;
				
			}
			player2=1;
				player1=0;
			
				mp2=1;
			repaint();
			
		}


	}
	public void mouseExited(MouseEvent m){}
	public void mouseEntered(MouseEvent m){}
	public void mouseReleased(MouseEvent m){}
	public void mousePressed(MouseEvent m){}
}


class Path
{
	public int x,y,pos;
	public Path next; 
}

class ludo 
{
	public static void main(String[] args) {
		Abc a=new Abc();
	}
}


class Game
{
	Random r=new Random();
	int i=0;

	public int rand()
	{
		i=r.nextInt(6);
		return (i+1);
	}
	public Path redinit()
	{
		Path pr,temp,node;
		int x=270,y=530;
		pr=null;
		temp=node=null;
	
		for(int j=2;j<=5;j++)
		{
			x=x+50;
			if(pr==null)
			{
				temp=new Path();
				temp.x=x;
				temp.pos=2;
				temp.y=y;
				temp.next=null;
				node=temp;
				pr=temp;
				
			}
			else
			{
				temp=new Path();
				temp.x=x;
				temp.y=y;
				temp.pos=j;
				temp.next=null;
				node.next=temp;
				node=temp;
			}
		}
		x=520;y=530;
		for(int i=6;i<=11;i++)
		{			
				y=y-52;
			
				temp=new Path();
				temp.x=x;
				temp.y=y;
				temp.pos=i;
				temp.next=null;
				node.next=temp;
				node=temp;
		
		}
	
				temp=new Path();
				temp.x=x+55;
				temp.y=y;
				temp.pos=12;
				temp.next=null;
				node.next=temp;
				node=temp;
				temp=new Path();
				temp.x=x+110;
				temp.y=y;
				temp.pos=13;
				temp.next=null;
				
				node.next=temp;
				node=temp; 
				
		x=x+110;
		
		for(int i=14;i<=18;i++)
		{	

				y=y+52;
				temp=new Path();
				temp.x=x;
				temp.y=y;
				temp.pos=i;
				temp.next=null;
				
				node.next=temp;
				node=temp;
		
		}
		x=640;
		y=518;
		
		for(int i=19;i<=24;i++)
		{
			x=x+50;
				y=y;
				temp=new Path();
				temp.x=x;
				temp.y=y;
				temp.pos=i;
				temp.next=null;
				
				node.next=temp;
				node=temp;
		}

		
				temp=new Path();
				temp.x=x;
				temp.y=y+60;
				temp.pos=25;
				temp.next=null;
				
				node.next=temp;
				node=temp;

				temp=new Path();
				temp.x=x;
				temp.y=y+120;
				temp.pos=26;
				temp.next=null;
				
				node.next=temp;
				node=temp;
		
		y=y+120;
		for(int i=27;i<=31;i++)
		{
				x=x-50;
				temp=new Path();
				temp.x=x;
				temp.y=y;
				temp.pos=i;
				temp.next=null;
			
				node.next=temp;
				node=temp;
		}
		x=x-50;
		for(int i=32;i<=37;i++)
		{
				y=y+50;
				temp=new Path();
				temp.x=x;
				temp.y=y;
				temp.pos=i;
				temp.next=null;
				
				node.next=temp;
				node=temp;
		}
		
				temp=new Path();
				temp.x=x-60;
				temp.y=y;
				temp.pos=38;
				temp.next=null;
				
				node.next=temp;
				
				node=temp;
				temp=new Path();
				temp.x=x-120;
				temp.y=y;
				temp.pos=39;
				temp.next=null;
			
				node.next=temp;
				node=temp;
		x=x-120;
		
		for(int i=40;i<=44;i++)
		{
				y=y-50;
				temp=new Path();
				temp.x=x;
				temp.y=y;
				temp.pos=i;
				temp.next=null;
			
				node.next=temp;
				node=temp;
		}
		y=640;
		
		for(int i=45;i<=50;i++)
		{
				x=x-50;
				temp=new Path();
				temp.x=x;
				temp.y=y;
				temp.pos=i;
				temp.next=null;
				
				node.next=temp;
				node=temp;
		}
		
				temp=new Path();
				temp.x=x;
				temp.y=y-50;
				temp.pos=51;
				temp.next=null;
				
				node.next=temp;
				node=temp;
		
		y=y-50;
		for(int i=52;i<=57;i++)
		{
				x=x+50;
				temp=new Path();
				temp.x=x;
				temp.y=y;
				temp.pos=i;
				temp.next=null;
				
				node.next=temp;
				node=temp;
		}
		return pr;
	}
	public void disp(Path p)
	{
		if(p==null)
			System.out.print("empty");
		else
			while(p!=null)
			{
				System.out.println(p.pos);
				p=p.next;
			}
	}
	public Path yellowInit()
	{
		Path py,temp,node;
		int x=890,y=640;
		py=null;
		temp=node=null;
		for(int j=2;j<=5;j++)
		{
			x=x-50;
			if(py==null)
			{
				temp=new Path();
				temp.x=x;
				temp.pos=2;
				temp.y=y;
				temp.next=null;
				
				node=temp;
				py=temp;
				
			}
			else
			{
				temp=new Path();
				temp.x=x;
				temp.y=y;
				temp.pos=j;
				temp.next=null;
				
				node.next=temp;
				node=temp;
			}
		}
		x=x-50;
		for(int i=6;i<=11;i++)
		{			
				y=y+52;
			
				temp=new Path();
				temp.x=x;
				temp.y=y;
				temp.pos=i;
				temp.next=null;
				
				node.next=temp;
				node=temp;
		
		}

		
				temp=new Path();
				temp.x=x-55;
				temp.y=948;
				temp.pos=12;
				temp.next=null;
				
				node.next=temp;
				node=temp;
				temp=new Path();
				temp.x=x-110;
				temp.y=948;
				temp.pos=13;
				temp.next=null;
				
				node.next=temp;
				node=temp; 
				
		x=x-110;
		y=948;
		
		for(int i=14;i<=18;i++)
		{	

				y=y-52;
				temp=new Path();
				temp.x=x;
				temp.y=y;
				temp.pos=i;
				temp.next=null;
				
				node.next=temp;
				node=temp;
		
		}
		y=y-52;
		
		for(int i=19;i<=24;i++)
		{
				x=x-51;
				y=y;
				temp=new Path();
				temp.x=x;
				temp.y=y;
				temp.pos=i;
				temp.next=null;
				
				node.next=temp;
				node=temp;
		}

		
				temp=new Path();
				temp.x=x;
				temp.y=y-60;
				temp.pos=25;
				temp.next=null;
				
				node.next=temp;
				node=temp;

				temp=new Path();
				temp.x=x;
				temp.y=y-120;
				temp.pos=26;
				temp.next=null;
				
				node.next=temp;
				node=temp;
		
		y=y-120;
		for(int i=27;i<=31;i++)
		{
				x=x+50;
				temp=new Path();
				temp.x=x;
				temp.y=y;
				temp.pos=i;
				temp.next=null;
				
				node.next=temp;
				node=temp;
		}
		x=x+50;
		
		for(int i=32;i<=37;i++)
		{
				y=y-50;
				temp=new Path();
				temp.x=x;
				temp.y=y;
				temp.pos=i;
				temp.next=null;
				
				node.next=temp;
				node=temp;
		}
		
				temp=new Path();
				temp.x=x+60;
				temp.y=y;
				temp.pos=38;
				temp.next=null;
				
				node.next=temp;
				
				node=temp;
				temp=new Path();
				temp.x=x+120;
				temp.y=y;
				temp.pos=39;
				temp.next=null;
				
				node.next=temp;
				node=temp;
		x=x+120;
		
		for(int i=40;i<=44;i++)
		{
				y=y+50;
				temp=new Path();
				temp.x=x;
				temp.y=y;
				temp.pos=i;
				temp.next=null;
				
				node.next=temp;
				node=temp;
		}
		y=y+50;
		
		for(int i=45;i<=50;i++)
		{
				x=x+50;
				temp=new Path();
				temp.x=x;
				temp.y=y;
				temp.pos=i;
				temp.next=null;
				
				node.next=temp;
				node=temp;
		}
		
				temp=new Path();
				temp.x=x;
				temp.y=y+59;
				temp.pos=51;
				temp.next=null;
				
				node.next=temp;
				node=temp;
		y=y+59;
		
		for(int i=52;i<=57;i++)
		{
				x=x-50;
				temp=new Path();
				temp.x=x;
				temp.y=y;
				temp.pos=i;
				temp.next=null;
				
				node.next=temp;
				node=temp;
		}
		return py;
	}
	public Path position(Path node,int n)
	{

		if(node==null)
		{
			return null;
		}
		else
		{
			while(node!=null)
			{
				if(node.pos==n)
					return node;
				node=node.next;
			}
		}
		return null;
	}
	

}





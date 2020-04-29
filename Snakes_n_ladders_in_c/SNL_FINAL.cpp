#include<stdio.h>
#include<conio.h>
#include<graphics.h>
#include<stdlib.h>
#include<dos.h>


int music(int pitch, int time)
{
sound(pitch);
delay(500);
nosound();
return(0);
}




int diceplay2()
{

	srand(time(NULL));
	int i = 0;
	for (i = 0; i < 100; i++)
	{
		int dice = (rand() % 6) + 1;
		return dice;
	}
}

void bgm_sound(void)
 {

      music(166, 2000);
      music(176, 2000);
      music(185, 2000);
 }


/*
	1)size of board is 360x360.
	2)size of one block is 36x36.
	3) starting coordinates for block 1(center point) are x=18,y=422.
*/
int x1=20,y1=412; //starting coordinates for player 1
int x2=20,y2=422;
int x,y;
int temp_x=0;
int temp_y=0; //Previous point coordinates to erase
//int player_flag=1;

int x_b=10,y_b=425;



void ladder_sound()
{
   int a;

   for (a = 200; a <= 1000; a = a + 20)
   {
      sound(a);
      delay(25);
   }

   nosound();
}

void snake_sound()
{
   int a;

   for (a = 1000; a >= 200; a = a - 20)
   {
      sound(a);
      delay(25);
   }

   nosound();
}

void six_sound()
{
   int a;


   for (a = 1000; a >= 200; a = a - 50)
   {
      sound(a);
      delay(10);
   }
   for (a = 200; a <= 5000; a = a + 300)
   {
      sound(a);
      delay(10);
   }

   nosound();
}
					       //#
int diceplay()
{
    int temp_dice;

    temp_dice=(rand()%6)+1;
    return temp_dice;
}

void start_screen()             //#START
{
    int gdriver=DETECT,gmode;

    initgraph(&gdriver,&gmode,"C:\\TURBOC3\\BGI");

    settextstyle(3,0,5);
    outtextxy(100,200,"Snakes 'N' Ladders");
    setcolor(CYAN);
    outtextxy(160,250,"NEON");
    setcolor(LIGHTGREEN);
    outtextxy(280,250,"EDITION");

    setcolor(WHITE);
    settextstyle(6,0,2);
    outtextxy(190,400,"Press any key to Start.");
    bgm_sound(); //background music
    getch();
    closegraph();
}

void end_screen(int player)
{
    int gdriver=DETECT,gmode;
    char end_text[30];
    initgraph(&gdriver,&gmode,"C:\\TURBOC3\\BGI");

    settextstyle(3,0,5);
    sprintf(end_text,"Player %d Wins!",player);
    outtextxy(140,200,end_text);
    settextstyle(6,0,2);
    outtextxy(160,350,"Thank you for Playing...");
    bgm_sound(); //background music

    getch();
    closegraph();
}


void dicecube_ui(int number)
{
    setlinestyle(SOLID_LINE,1,1);

    line(500,200,550,200);
    delay(30);
    line(550,200,550,250);
    delay(30);
    line(550,250,500,250);
    delay(30);
    line(500,250,500,200);
    delay(30);

    line(520,180,570,180);
    delay(20);
    line(570,180,570,230);
    delay(20);
    //line(570,230,520,230);
    //line(520,230,520,180);

    line(500,200,520,180);
    delay(10); //connecting lines
    line(550,200,570,180);
    delay(10);
    line(550,250,570,230);
    delay(10);

    switch(number)
    {
    case 1:
        circle(525,225,3);
	break;
    case 2:
        circle(515,225,3);
	circle(535,225,3);
        break;
    case 3:
	circle(525,225,3);
	circle(515,225,3);
        circle(535,225,3);
        break;
    case 4:
        circle(515,215,3);
        circle(535,215,3);
	circle(535,235,3);
        circle(515,235,3);
        break;
    case 5:
        circle(525,225,3);
	circle(515,215,3);
	circle(535,215,3);
	circle(535,235,3);
        circle(515,235,3);
        break;
    case 6:
        circle(515,225,3);
        circle(535,225,3);
	circle(515,215,3);
        circle(535,215,3);
        circle(535,235,3);
	circle(515,235,3);
	break;
    }
}
                    //#END


int ladder(int a,int player_flag)
{
    int p,q,col;

    if(player_flag == 1)
    {


    switch(a)
    {
	case 2 : setcolor(0);
		 circle(x1,y1,3);
		 setcolor(4);
		 x1=92;
		 y1=304;
		 circle(92,304,3);
		 return 38;

	case 6 : setcolor(0);
		 circle(x1,y1,3);
		 setcolor(4);
		 x1=164;
		 y1=196;
		 circle(164,196,3);
		 return 65;

	case 32 : setcolor(0);
		 circle(x1,y1,3);
		 setcolor(4);
		 x1=92;
		 y1=88;
		 circle(92,88,3);
		 return 98;

	case 59 : setcolor(0);
		 circle(x1,y1,3);
		 setcolor(4);
		 x1=308;
		 y1=124;
		 circle(308,124,3);
		 return 89;

    }
   }
  else
    {
      switch(a)
	{
	case 2 : setcolor(0);
		 circle(x2,y2,3);
		 setcolor(3);
		 x2=92;
		 y2=314;
		 circle(92,314,3);
		 return 38;

	case 6 : setcolor(0);
		 circle(x2,y2,3);
		 setcolor(3);
		 x2=164;
		 y2=206;
		 circle(164,206,3);
		 return 65;

	case 32 : setcolor(0);
		 circle(x2,y2,3);
		 setcolor(3);
		 x2=92;
		 y2=98;
		 circle(92,98,3);
		 return 98;

	case 59 : setcolor(0);
		 circle(x2,y2,3);
		 setcolor(3);
		 x2=308;
		 y2=134;
		 circle(308,134,3);
		 return 89;
       }
    }
}

int snake(int a,int player_flag)
{
    int p,q,col;

    if(player_flag == 1)
    {


      switch(a)
       {
	case 31 :     setcolor(0);
		      circle(x1,y1,3);
		      setcolor(4);
		      x1=164;
		      y1=412;
		      circle(164,412,3);
		      return 5;

	case 77 :     setcolor(0);
		      circle(x1,y1,3);
		      setcolor(4);
		      x1=56;
		      y1=304;
		      circle(56,304,3);
		      return 39;

	case 95 : setcolor(0);
		  circle(x1,y1,3);
		  setcolor(4);
		  x1=128;
		  y1=340;
		  circle(128,340,3);
		  return 24;

       }
    }

    else
    {
     switch(a)
      {
	case 31 : setcolor(0);
		  circle(x1,y1,3);
		  setcolor(4);
		  x1=164;
		  y1=422;
		  circle(164,422,3);
		  return 5;

	case 77 : setcolor(0);
		  circle(x1,y1,3);
		  setcolor(4);
		  x1=56;
		  y1=314;
		  circle(56,314,3);
		  return 39;

	case 95 : setcolor(0);
		  circle(x1,y1,3);
		  setcolor(4);
		  x1=128;
		  y1=350;
		  circle(128,350,3);
		  return 24;

      }

   }
}


int printboard()                //print board
{
    int gdriver=DETECT,gmode,choice,x1,x2,y1,y2;
    int i=1,x_inc=0,y_inc=0,stop_flag=0,start_flag=0; //#
    int flag=1;
    char j[4];
    initgraph(&gdriver,&gmode,"C:\\TURBOC3\\BGI");
    settextstyle(3,0,1);                           //#START
    outtextxy(100,1,"Snakes 'N' Ladders");
    setcolor(CYAN);
    outtextxy(130,25,"NEON");
    setcolor(LIGHTGREEN);
    outtextxy(190,25,"EDITION");

    setcolor(WHITE);                         //#END

    setlinestyle(SOLID_LINE,1,5);

    line(0,80,360,80);
    line(0,80,0,440);
    line(360,80,360,440);
    line(0,440,360,440);

    setlinestyle(DOTTED_LINE,1,1);

    line(0,116,360,116);
    line(0,152,360,152);
    line(0,188,360,188);
    line(0,224,360,224);
    line(0,260,360,260);
    line(0,296,360,296);
    line(0,332,360,332);
    line(0,368,360,368);
    line(0,404,360,404);

    line(36,80,36,440);
    line(72,80,72,440);
    line(108,80,108,440);
    line(144,80,144,440);
    line(180,80,180,440);
    line(216,80,216,440);
    line(252,80,252,440);
    line(288,80,288,440);
    line(324,80,324,440);
    line(360,80,360,440);


    setcolor(GREEN);
    setlinestyle(CENTER_LINE,1,1);

    line(45,422,75,315);  //LADDER 1
    line(47,422,77,315);
    line(60,422,90,315);
    line(62,422,92,315);

    line(200,422,150,215);  //LADDER 2
    line(202,422,152,215);
    line(215,422,165,215);
    line(217,422,167,215);

    line(300,322,80,100);  //LADDER 3
    line(302,322,82,100);
    line(315,322,95,100);
    line(317,322,97,100);

    line(40,250,300,120);  //LADDER 4
    line(42,250,302,120);
    line(60,250,320,120);
    line(62,250,322,120);

    setcolor(YELLOW);
    arc(324,350,75,180,30);   //SNAKE 1- 31 to 5
    arc(265,345,250,360,30);
    arc(252,404,70,170,30);
    arc(180,368,250,330,50);

    arc(126,206,90,190,30);     //SNAKE 2- 77 to 39
    arc(72,224,280,28,28);
    arc(90,296,105,200,47);

    arc(180,152,280,70,50);    // SANKE 3- 95 to 24
    arc(230,238,130,220,50);
    arc(153,302,270,40,50);


    setlinestyle(SOLID_LINE,1,1);
    settextstyle(2,0,4);
    setcolor(WHITE);  //#

    line(380,0,380,500); // ui box line  //#

    setcolor(LIGHTMAGENTA); //#

    for(i=1;i<=100;i++) //print board numbers   //#START
    {

	if(i%10==0)
	{
		sprintf(j,"%d",i);
		outtextxy(x_b,y_b,j);
		flag++;
		y_inc=36;
		x_inc=0;
		if(flag%2==1)
			x_b+=x_inc;
		else
			x_b-=x_inc;
		 y_b-=y_inc;

	}
	else
	{
	    sprintf(j,"%d",i);
	    outtextxy(x_b,y_b,j);
	    start_flag++;
	    x_inc=36;
	    y_inc=0;
	    if(flag%2==1)
		x_b+=x_inc;
	    else
		x_b-=x_inc;
	    y_b-=y_inc;

	}
    }
    settextstyle(0,0,1);
}                                               //#END

int convert()    //convert factor
{
    return 36;
}

void printpixel(int x_incrementer,int y_incrementer,int flag,int player_flag)  //print the pixel(only x added yet)
{
    if(player_flag==1)
    {
		temp_x=x1;
		temp_y=y1;

		if(flag%2==1)
			x1+=x_incrementer;
		else
			x1-=x_incrementer;
		y1-=y_incrementer;

		setcolor(BLACK);
		circle(temp_x,temp_y,3);
		setcolor(4);
		circle(x1,y1,3);
	}
	else
	{
		temp_x=x2;
		temp_y=y2;

		if(flag%2==1)
			x2+=x_incrementer;
		else
			x2-=x_incrementer;

		y2-=y_incrementer;

		setcolor(BLACK);
		circle(temp_x,temp_y,3);
		setcolor(LIGHTCYAN);
		circle(x2,y2,3);
	}


}



void display(int x_incrementer,int y_incrementer,int flag,int player_flag)  //displays everything
{
    printpixel(x_incrementer,y_incrementer,flag,player_flag);
}




int main()
{
    int dice=0,count1=0,count2=0,curr_val1=1,curr_val2=1;
    int flag[3]={0,1,1},flag_cal;   //flag to decide whether even or odd row(odd=right/even=left)
    int x_incrementer=0,y_incrementer=0;
    char dice_ui[128],currvalue1_ui[128],currvalue2_ui[128];
    int points[]={390,10,700,10,700,450,390,450};              //#
    int player_flag=1;

    start_screen(); //start screen

    int gdriver=DETECT,gmode,choice,x1,x2,y1,y2;
    initgraph(&gdriver,&gmode,"C:\\TURBOC3\\BGI");

    printboard();

    display(x_incrementer,y_incrementer,flag[1],player_flag);
    player_flag=2;
    display(x_incrementer,y_incrementer,flag[2],player_flag);
    player_flag=1;

    while(count1<=99||count2<=99)
    {
    if(count1>=99)
    { //goto end screen    //#
	end_screen(1);
	break;
    }	              //#
    else if(count2>=99)
    {                  //#
	end_screen(2);
	break;
    }	                //#
    dice=diceplay2();
    if(player_flag==1)
    {
        sprintf(currvalue1_ui,"Count_1=%d",(count1));
        sprintf(currvalue2_ui,"Count_2=%d",count2);
    }
    else if(player_flag==2)
    {
        sprintf(currvalue1_ui,"Count_1=%d",count1);
        sprintf(currvalue2_ui,"Count_2=%d",count2);
    }
    sprintf(dice_ui,"Dice=%d",dice);
    setlinestyle(SOLID_LINE,1,5);

    if(player_flag==1)
    {
      if(count1+dice > 100)
	     {

	     }
	  else
      {


		setcolor(BLACK);                    //#START
		setfillstyle(SOLID_FILL,BLACK);
		fillpoly(4,points);

		setcolor(WHITE);
		outtextxy(470,40,"PLAYER-1");
		outtextxy(470,380,"PLAYER-2");
		setcolor(RED);
		circle(500,70,5);
		setcolor(CYAN);
	circle(500,410,5);
	setcolor(WHITE);
	if(player_flag==1)
	    circle(500,70,8);
	else if(player_flag==2)
	    circle(500,410,8);
		dicecube_ui(dice);

		if(dice==6)
        {
            six_sound();
            if(player_flag==1)
                outtextxy(400,100,"6! You get one more chance!");
            else if(player_flag==2)
                outtextxy(400,430,"6! You get one more chance!");
        }
	    for(count1=curr_val1;count1<=(curr_val1+dice)-1;count1++)
	    {

		  if(count1>99)
				 break;


		  if(count1==1)
			{
				display(x_incrementer,y_incrementer,flag[1],player_flag);
				getch();
			}

		   if(count1%10==0)
			{
			flag[1]++;
			y_incrementer=convert();
			x_incrementer=0;
			display(x_incrementer,y_incrementer,flag[1],player_flag);
			}
		   else
			{
				x_incrementer=convert();
				y_incrementer=0;
				display(x_incrementer,y_incrementer,flag[1],player_flag);
			}
			delay(100);
	    }
	if(count1 == 2 || count1 == 6 || count1 == 32 || count1 == 59 )
	{
         ladder_sound();
         outtextxy(420,120,"Ladder! You went UP!");
		 count1 = ladder(count1,player_flag);
		 flag_cal=(count1/10)+1;
		 flag[1]=flag_cal;
	}

	    if(count1 == 31 || count1 == 77 || count1 == 95)
	{
	     snake_sound();
	     outtextxy(420,120,"Snake! You went DOWN!");
         count1 = snake(count1,player_flag);
		 flag_cal=(count1/10)+1;
		 flag[1]=flag_cal;
	}
	  }
   }

  else if(player_flag==2)
   {
    if(count2+dice >100)
     {

     }
    else
     {


		setcolor(BLACK);                             //#START
		setfillstyle(SOLID_FILL,BLACK);
		fillpoly(4,points);

		setcolor(WHITE);
		outtextxy(470,40,"PLAYER-1");
		outtextxy(470,380,"PLAYER-2");
		setcolor(RED);
		circle(500,70,5);
		setcolor(CYAN);
	circle(500,410,5);
	setcolor(WHITE);
	if(player_flag==1)
	    circle(500,70,8);
	else if(player_flag==2)
	    circle(500,410,8);
		dicecube_ui(dice);
		if(dice==6)
        {
            six_sound();
            if(player_flag==1)
                outtextxy(400,100,"6! You get one more chance!");
            else if(player_flag==2)
                outtextxy(400,430,"6! You get one more chance!");
        }   //#END
	 for(count2=curr_val2;count2<=(curr_val2+dice)-1;count2++) //inner loop
	  {


			if(count2>99)
				break;

			if(count2==1)
			{
				display(x_incrementer,y_incrementer,flag[2],player_flag);
				getch();
			}

			if(count2%10==0)
			{
			flag[2]++;
			y_incrementer=convert();
			x_incrementer=0;
			display(x_incrementer,y_incrementer,flag[2],player_flag);
			}
			else
			{
			x_incrementer=convert();
			y_incrementer=0;
			display(x_incrementer,y_incrementer,flag[2],player_flag);
		}
		delay(100);
    }
    if(count2 == 2 || count2 == 6 || count2 == 32 || count2 == 59 )
	   {
	      ladder_sound();
          outtextxy(420,350,"Ladder! You went UP!");
	      count2 = ladder(count2,player_flag);
	      flag_cal=(count2/10)+1;
	      flag[2]=flag_cal;
	   }

	  if(count2 == 31 || count2 == 77 || count2 == 95)
	   {
	    snake_sound();
        outtextxy(420,350,"Snake! You went DOWN!");
	    count2 = snake(count2,player_flag);
	    flag_cal=(count2/10)+1;
	    flag[2]=flag_cal;
	   }
     }

   }


    if(dice!=6)
    {
	    if(player_flag==1)
	    {
			player_flag=2;
			curr_val1=count1;
	    }
	else if(player_flag==2)
	     {
			player_flag=1;
			curr_val2=count2;
	     }
	     x_incrementer=y_incrementer=0;
    }
    else
    {
	curr_val1=count1;
	curr_val2=count2;
    }
   // curr_val1=count1;
   // curr_val2=count2;

    getch();
   }

    getch();
    closegraph();
    return 0;
}

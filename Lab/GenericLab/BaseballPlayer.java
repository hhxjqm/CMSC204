/**
   A baseball player
*/
public class BaseballPlayer implements Measurable
{  
   private double battingAverage;
   private String name;
   private String team;

   /**
      Constructs a baseball player with a zero batting average.
   */
   public BaseballPlayer()
   {   
      battingAverage = 0;
      name = "";
      team = "";
   }

   /**
      Constructs a baseball player with a given name, team and batting average.
      @param batavg the batting average
      @param name player's name
      @param team player's team
   */
   public BaseballPlayer(String name, String team, double batavg)
   {   
      battingAverage = batavg;
      this.name = name;
      this.team = team;
   }

   /**
   Gets the name of the player.
   @return the player's name
   */
   public String getName()
   {
	   return name;
   }
   
   /**
   Gets the ream of the player.
   @return the player's team
   */
   public String getTeam()
   {
	   return team;
   }
   
   /**
      Gets the batting average of the player.
      @return the batting average
   */
   public double getBattingAverage()
   {   
      return battingAverage;
   }

   public double getMeasure()
   {
      return battingAverage;
   }
}
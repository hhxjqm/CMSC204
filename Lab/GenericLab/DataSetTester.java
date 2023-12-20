/**
   This program tests the DataSetGen class.
*/
public class DataSetTester
{
   public static void main(String[] args)
   {
      DataSetGen<BankAccount> bankData = new DataSetGen<BankAccount>();

      bankData.add(new BankAccount(0));
      bankData.add(new BankAccount(10000));
      bankData.add(new BankAccount(2000));
      
      System.out.println("Bank Account");
      System.out.println("Average balance: " + bankData.getAverage());
      System.out.println("Expected: 4000");
      BankAccount max = bankData.getMaximum();
      System.out.println("Highest balance: " + max.getBalance());
      System.out.println("Expected: 10000");
      
      DataSetGen<BaseballPlayer> battingAvgData = new DataSetGen<BaseballPlayer>();
      
      System.out.println("Batting Averages");
      battingAvgData.add(new BaseballPlayer("Derek Jeter", "New York Yankees", .323));
      battingAvgData.add(new BaseballPlayer("Melky Cabria","San Fransico Giants", .346));
      battingAvgData.add(new BaseballPlayer("Adrian Beltre","Texas Rangers", .319));
      

      System.out.println("Average batting average: " + battingAvgData.getAverage());
      System.out.println("Expected: .329");
      BaseballPlayer maxA = battingAvgData.getMaximum();
      System.out.println("Highest batting average: " + maxA.getBattingAverage() + " "+ maxA.getName() + " of the " + maxA.getTeam());
      System.out.println("Expected: .346 Melky Cabria of the San Fransicso Giants");
   }
}
package examples.behaviours;

import jade.src.gd.GD;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class OneShotAgentGD extends Agent {

  protected void setup() {
    addBehaviour(new MyOneShotBehaviour());
  } 

  private class MyOneShotBehaviour extends OneShotBehaviour {

    public void action() {
      GD.execute();

    } 
    
    public int onEnd() {
      myAgent.doDelete();   
      return super.onEnd();
    } 
  }    // END of inner class ...Behaviour
}
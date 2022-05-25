package examples.behaviours;

import jade.src.lr.LR;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class OneShotAgentLR extends Agent {

  protected void setup() {
    addBehaviour(new MyOneShotBehaviour());
  } 

  private class MyOneShotBehaviour extends OneShotBehaviour {

    public void action() {
      LR.execute();

    } 
    
    public int onEnd() {
      myAgent.doDelete();   
      return super.onEnd();
    } 
  }    // END of inner class ...Behaviour
}
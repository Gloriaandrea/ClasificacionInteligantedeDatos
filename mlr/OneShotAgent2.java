package examples.behaviours;

import jade.src.mlr.MLR;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class OneShotAgent2 extends Agent {

  protected void setup() {
    addBehaviour(new MyOneShotBehaviour());
  } 

  private class MyOneShotBehaviour extends OneShotBehaviour {

    public void action() {
      MLR.execute();

    } 
    
    public int onEnd() {
      myAgent.doDelete();   
      return super.onEnd();
    } 
  }    // END of inner class ...Behaviour
}
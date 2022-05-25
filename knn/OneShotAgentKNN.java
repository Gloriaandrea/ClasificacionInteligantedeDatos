package examples.behaviours;

import jade.src.knn.KNN;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class OneShotAgentKNN extends Agent {

  protected void setup() {
    addBehaviour(new MyOneShotBehaviour());
  } 

  private class MyOneShotBehaviour extends OneShotBehaviour {

    public void action() {
      KNN.execute();

    } 
    
    public int onEnd() {
      myAgent.doDelete();   
      return super.onEnd();
    } 
  }    // END of inner class ...Behaviour
}
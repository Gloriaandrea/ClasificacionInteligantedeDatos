package jade.src.examples.behaviours;



import jade.src.slr.SLR;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class OneShotAgent1 extends Agent {

  protected void setup() {
    
    addBehaviour(new MyOneShotBehaviour());
  } 

  private class MyOneShotBehaviour extends OneShotBehaviour {

    public void action() {
        SLR.execute();

    } 
    
    public int onEnd() {
      myAgent.doDelete();   
      return super.onEnd();
    } 
  }    // END of inner class ...Behaviour
}
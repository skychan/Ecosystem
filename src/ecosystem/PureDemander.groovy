/**
 * 
 * This file was automatically generated by the Repast Simphony Agent Editor.
 * Please see http://repast.sourceforge.net/ for details.
 * 
 */

/**
 *
 * Set the package name.
 *
 */
package ecosystem

/**
 *
 * Import the needed packages.
 *
 */
import java.io.*
import java.math.*
import java.util.*
import javax.measure.unit.*
import org.jscience.mathematics.number.*
import org.jscience.mathematics.vector.*
import org.jscience.physics.amount.*
import repast.simphony.adaptation.neural.*
import repast.simphony.adaptation.regression.*
import repast.simphony.context.*
import repast.simphony.context.space.continuous.*
import repast.simphony.context.space.gis.*
import repast.simphony.context.space.graph.*
import repast.simphony.context.space.grid.*
import repast.simphony.engine.environment.*
import repast.simphony.engine.schedule.*
import repast.simphony.engine.watcher.*
import repast.simphony.groovy.math.*
import repast.simphony.integration.*
import repast.simphony.matlab.link.*
import repast.simphony.query.*
import repast.simphony.query.space.continuous.*
import repast.simphony.query.space.gis.*
import repast.simphony.query.space.graph.*
import repast.simphony.query.space.grid.*
import repast.simphony.query.space.projection.*
import repast.simphony.parameter.*
import repast.simphony.random.*
import repast.simphony.space.continuous.*
import repast.simphony.space.gis.*
import repast.simphony.space.graph.*
import repast.simphony.space.grid.*
import repast.simphony.space.projection.*
import repast.simphony.ui.probe.*
import repast.simphony.util.*
import simphony.util.messages.*
import static java.lang.Math.*
import static repast.simphony.essentials.RepastEssentials.*

/**
 *
 * This is an agent.
 *
 */
public class PureDemander  {

    /**
     *
     * indicator to show if the demander have need
     * @field need
     *
     */
    @Parameter (displayName = "Need", usageName = "need")
    public boolean getNeed() {
        return need
    }
    public void setNeed(boolean newValue) {
        need = newValue
    }
    public boolean need = false

    /**
     *
     * This is a test adder
     * @field unit
     *
     */
    @Parameter (displayName = "addition", usageName = "unit")
    public int getUnit() {
        return unit
    }
    public void setUnit(int newValue) {
        unit = newValue
    }
    public int unit = 5

    /**
     *
     * Order List
     * @field orderList
     *
     */
    @Parameter (displayName = "Order List", usageName = "orderList")
    public ArrayList getOrderList() {
        return orderList
    }
    public void setOrderList(ArrayList newValue) {
        orderList = newValue
    }
    public ArrayList orderList = new ArrayList()

    /**
     *
     * New order
     * @field newOrder
     *
     */
    @Parameter (displayName = "New order", usageName = "newOrder")
    public ArrayList getNewOrder() {
        return newOrder
    }
    public void setNewOrder(ArrayList newValue) {
        newOrder = newValue
    }
    public ArrayList newOrder = new ArrayList()

    /**
     *
     * This value is used to automatically generate agent identifiers.
     * @field serialVersionUID
     *
     */
    private static final long serialVersionUID = 1L

    /**
     *
     * This value is used to automatically generate agent identifiers.
     * @field agentIDCounter
     *
     */
    protected static long agentIDCounter = 1

    /**
     *
     * This value is the agent's identifier.
     * @field agentID
     *
     */
    protected String agentID = "PureDemander " + (agentIDCounter++)

    /**
     *
     * This is the step behavior.
     * @method CreateOrder
     *
     */
    public ArrayList<Task> CreateOrder(String[] taskTypes) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        Order o = new Order()

        // This is a loop.
        for (task in taskTypes) {

            // This is a task.
            Task t = new Task()
            t.setType(task)
            t.SetValues()
            o.Add(t)

        }

        // This is a task.
        returnValue = o
        // Return the results.
        return returnValue

    }

    /**
     *
     * Generate Need
     * @method changeNeed
     *
     */
    public void changeNeed() {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // Check if it already have needs
        if (this.getNeed()) {


        } else  {


            // to need or not
            if (RandomHelper.nextIntFromTo(0, 1)) {

                // have need is to generate order
                this.setNeed(true)
                this.newOrder.clear()
                this.setNewOrder(this.CreateOrder())

            } else  {


            }

        }
    }

    /**
     *
     * This method provides a human-readable name for the agent.
     * @method toString
     *
     */
    @ProbeID()
    public String toString() {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // Set the default agent identifier.
        returnValue = this.agentID
        // Return the results.
        return returnValue

    }


}


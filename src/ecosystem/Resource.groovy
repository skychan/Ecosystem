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
public class Resource extends ecosystem.Machine  {

    /**
     *
     * This is an agent property.
     * @field sourceable
     *
     */
    @Parameter (displayName = "Source-able", usageName = "sourceable")
    public int getSourceable() {
        return sourceable
    }
    public void setSourceable(int newValue) {
        sourceable = newValue
    }
    public int sourceable = 0

    /**
     *
     * The var to record compete service temp
     * @field competeServiceTemp
     *
     */
    @Parameter (displayName = "Compete service temp", usageName = "competeServiceTemp")
    public def getCompeteServiceTemp() {
        return competeServiceTemp
    }
    public void setCompeteServiceTemp(def newValue) {
        competeServiceTemp = newValue
    }
    public def competeServiceTemp = []

    /**
     *
     * The var to record compete service
     * @field competeService
     *
     */
    @Parameter (displayName = "Compete service", usageName = "competeService")
    public def getCompeteService() {
        return competeService
    }
    public void setCompeteService(def newValue) {
        competeService = newValue
    }
    public def competeService = []

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
    protected String agentID = "Resource " + (agentIDCounter++)

    /**
     *
     * This is the step behavior.
     * @method Resource
     *
     */
    public def Resource() {

        // This is a task.
        selectBehavior = new SelectInTask()
    }

    /**
     *
     * Response to the need call
     * @method ResponseService
     *
     */
    @Watch(
        watcheeClassName = 'ecosystem.PureProvider',
        watcheeFieldNames = 'serviceCalling',
        triggerCondition = '$watcher.serviceNeedCapacity == 0',
        whenToTrigger = WatcherTriggerSchedule.LATER,
        scheduleTriggerDelta = 0.2d
    )
    public def ResponseService(ecosystem.PureProvider watchedAgent) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if (this.getSourceable() > 0) {


            // This is an agent decision.
            if (this.getType() in watchedAgent.callContent.keySet()) {

                // This is a task.
                int tempCap = this.getSourceable()
                int i = 0
                Evaluation(this.competeServiceTemp)

                // This is a loop.
                while (tempCap > 0) {

                    // This is a task.
                    this.competeService << this.competeServiceTemp[i]
                    i += 1
                    tempCap -= this.competeServiceTemp[i].callContent[this.getType()]

                    // This is an agent decision.
                    if (i == this.competeServiceTemp.size()-1) {

                        // This is a task.
                        break

                    } else  {


                    }

                }

                // This is a task.
                this.competeServiceTemp = []

                // This is a loop.
                for (prd in this.competeService) {

                    // This is a task.
                    prd.addCandidates(this)

                }

                // This is a task.
                this.competeService = []

            } else  {


            }

        } else  {


        }
        // Return the results.
        return returnValue

    }

    /**
     *
     * Response to the need call
     * @method ResponseServiceCall
     *
     */
    @Watch(
        watcheeClassName = 'ecosystem.PureProvider',
        watcheeFieldNames = 'serviceCalling',
        triggerCondition = '$watcher.serviceNeedCapacity == 0',
        whenToTrigger = WatcherTriggerSchedule.LATER,
        scheduleTriggerDelta = 0.1d
    )
    public def ResponseServiceCall(ecosystem.PureProvider watchedAgent) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // Decide to take the task or not
        if (true) {


            // This is an agent decision.
            if (this.getSourceable() > 0) {


                // This is an agent decision.
                if (this.getType() in watchedAgent.callContent.keySet()) {

                    // This is a task.
                    this.competeServiceTemp << watchedAgent

                } else  {


                }

            } else  {


            }

        } else  {


        }
        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method Assign
     *
     */
    public void Assign(sc, amount) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
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


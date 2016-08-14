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
public class Task extends ecosystem.Job  {

    /**
     *
     * This is an agent property.
     * @field processingTime
     *
     */
    @Parameter (displayName = "ProcessingTime", usageName = "processingTime")
    public int getProcessingTime() {
        return processingTime
    }
    public void setProcessingTime(int newValue) {
        processingTime = newValue
    }
    public int processingTime = 0

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
    protected String agentID = "Task " + (agentIDCounter++)

    /**
     *
     * This is the step behavior.
     * @method Task
     *
     */
    public def Task() {

        // This is a task.
        selectBehavior = new SelectInTask()
        processBehavior = new ProcessInTask()
    }

    /**
     *
     * This is the step behavior.
     * @method setParameters
     *
     */
    public void setParameters(tdata) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is a loop.
        for (data in tdata.value) {


            // This is an agent decision.
            if (data.key == "p") {

                // This is a task.
                this.setProcessingTime(data.value)

            } else  {

                // This is a task.
                this.needResourceCapacity << data
                this.prepareStatus[data.key] = false
                this.candidates[data.key] = []

            }

        }

        // This is a task.
        println "task para setted"
        this.setStartTime(RunEnvironment.getInstance().getCurrentSchedule().getTickCount())
        this.setType(tdata.key)
        println "start at " + this.getStartTime()
    }

    /**
     *
     * Process the task
     * @method process
     *
     */
    @Watch(
        watcheeClassName = 'ecosystem.Task',
        watcheeFieldNames = 'remainingTime',
        triggerCondition = '$watchee.equals($watcher)',
        whenToTrigger = WatcherTriggerSchedule.LATER,
        scheduleTriggerDelta = 1d
    )
    public def process(ecosystem.Task watchedAgent) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if (this.getRemainingTime() > 0) {

            // This is a task.
            this.setRemainingTime(this.getRemainingTime()-1)

            // This is an agent decision.
            if (this.getRemainingTime() == 0) {


                // This is a loop.
                for (mac in this.getAllocation().values()) {

                    // The finish step
                    mac.Release(this)
                    mac.Next()
                    theRes.Next()
                    // This is a task.
                    RandomHelper.createNormal(mac.getQuality(),1)
                    double tempQuality = RandomHelper.getNormal().nextDouble()

                    // This is an agent decision.
                    if (tempQuality < this.getProductQuality()) {

                        // This is a task.
                        this.setProductQuality(tempQuality)

                    } else  {


                    }

                }


                // This is a loop.
                for (mac in this.getAllocation().values()) {

                    // This is a task.
                    mac.Review(this)
                    this.Review(mac)

                }

                // This is a task.
                println this.toString() + " is finished"
                this.setFinish(true)
                this.finishTime = RunEnvironment.getInstance().getCurrentSchedule().getTickCount()
                this.span = this.finishTime - this.getStartTime()

            } else  {


            }

        } else  {


        }
        // Return the results.
        return returnValue

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


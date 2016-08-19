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
public class ProcessInServiceCall implements ecosystem.ProcessBehavior {

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
    protected String agentID = "ProcessInServiceCall " + (agentIDCounter++)

    /**
     *
     * This is the step behavior.
     * @method Process
     *
     */
    public void Process(Job sc) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        //sc.owner.GenerateService(sc.needResourceCapacity)
        println "service call " + sc + " fininshed and we should to generate service"

        // This is a loop.
        for (mac in sc.getAllocation().keySet()) {

            // The finish step
            mac.Release(sc)
            // The finish step
            println mac
            println " jobList "
            println "sourceable = " + mac.sourceable
            println "available = " + mac.available
            println "useage = " + mac.useage

            // This is a loop.
            for (job in mac.jobList) {

                // This is a task.
                println job
                println job.prepareStatus
                println " need = " + job.needResourceCapacity[mac.getType()]

            }

            // This is a task.
            println " buffer "

            // This is a loop.
            for (job in mac.buffer) {

                // This is a task.
                println job
                println job.prepareStatus
                println " need = " + job.needResourceCapacity[mac.getType()]

            }


        }

        // This is a task.
        sc.setFinish(true)
        sc.finishTime = RunEnvironment.getInstance().getCurrentSchedule().getTickCount()
        sc.span = sc.finishTime - sc.getStartTime()
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


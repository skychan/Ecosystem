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
public class ResourceRelease implements ecosystem.ReleaseBehavior {

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
    protected String agentID = "ResourceRelease " + (agentIDCounter++)

    /**
     *
     * This is the step behavior.
     * @method Release
     *
     */
    public void Release(Task t, Machine r) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        r.setAvailable( r.getAvailable() + t.needResourceCapacity[ r.getType() ] )
        r.buffer.remove(t)
    }

    /**
     *
     * This is the step behavior.
     * @method Next
     *
     */
    public void Next(Machine m) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        Map newList = m.jobList.sort{ [ -it.value, it.key.getType() ] }
        def job = newList.keySet()[0]
        println "always get here?"

        // This is an agent decision.
        if (job.getClass() == ecosystem.ServiceCall) {


            // This is an agent decision.
            if (m.buffer == []) {

                // This is a task.
                job.prepareStatus[m.getType()] = true
                m.jobList.remove(job)
                m.setAvailable(m.getAvailable() - m.needCap[job])

            } else  {


            }

        } else  {

            // This is a task.
            println "always get here?"
            println "the mistery list" + m.jobList.keySet()

            // This is a loop.
            for (j in newList.keySet()) {


                // This is an agent decision.
                if (j.getClass() == ecosystem.ServiceCall) {

                    // This is a task.
                    println "can i get here?"
                    break

                } else  {


                    // This is an agent decision.
                    if (m.getAvailable() >= j.needResourceCapacity[m.getType()]) {

                        // This is a task.
                        m.assignBehavior.Buffer(j,m)
                        m.jobList.remove(j)

                    } else  {

                        // This is a task.
                        break

                    }

                }

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


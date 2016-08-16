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
public class SelectInTask implements ecosystem.SelectBehavior {

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
    protected String agentID = "SelectInTask " + (agentIDCounter++)

    /**
     *
     * Select
     * @method Select
     *
     */
    public def Select(t, candidates) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        def chosenMap = [:]

        // This is a loop.
        for (candidate in candidates) {

            // This is a task.
            def theType = candidate.key
            def theList = candidate.value
            chosenMap[theType] = Evaluation(theList)

            // This is a loop.
            for (res in theList) {

                // This is a task.
                res.competeList.remove(t)

            }


        }

        // This is a task.
        returnValue = chosenMap
        //println "after the selection and clear"
        // Return the results.
        return returnValue

    }

    /**
     *
     * Evaluation
     * @method Evaluation
     *
     */
    public def Evaluation(candidates) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if (candidates == []) {

            // This is a task.
            returnValue = null

        } else  {


            // This is an agent decision.
            if (candidates[0].getClass() == ecosystem.Service) {

                // This is a task.
                candidates.sort{[it.jobList.size()]}
                returnValue = candidates[0]

            } else  {

                // This is a task.
                candidates.sort{[-it.getAvailable(),it.jobList.size()]}
                returnValue = candidates[0]

            }

        }
        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method Allocate
     *
     */
    public Map Allocate(theOnes) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        int nullCount = theOnes.values().count(null)

        // This is an agent decision.
        if (nullCount > 1) {

            // This is a task.
            returnValue =  [success:false,allocation:[:]]

        } else  {


            // This is an agent decision.
            if (nullCount == 1) {


                // This is an agent decision.
                if (theOnes['service'] == null) {

                    // This is a task.
                    theOnes.remove('service')
                    returnValue =  [success:true,allocation:theOnes]

                } else  {

                    // This is a task.
                    returnValue =  [success:true,allocation:['service':theOnes['service']]]

                }

            } else  {

                // This is a task.
                def candidateList = theOnes.values()
                candidateList.sort{ [ it.getFullLength(), -it.getQuality() ] }

                // This is an agent decision.
                if (candidateList[0].getClass() == ecosystem.Service) {

                    // This is a task.
                    returnValue =  [success:true,allocation:['service':theOnes['service']]]

                } else  {

                    // This is a task.
                    theOnes.remove('service')
                    returnValue =  [success:true,allocation:theOnes]

                }

            }

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
    public void Assign(allocation, t) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is a loop.
        for (mac in allocation.values()) {

            // This is a task.
            mac.Assign(t)

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


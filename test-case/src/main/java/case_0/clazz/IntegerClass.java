package case_0.clazz;

import app.freelancer.syafiqq.text.classification.knn.core.Class;
import app.freelancer.syafiqq.text.classification.knn.core.Documents;
import case_0.StringTerm;
import case_0.StringTermContainer;
import case_0.document.Journal;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.math3.util.FastMath;
import org.jetbrains.annotations.NotNull;

/*
 * This <mknn> created by : 
 * Name         : syafiq
 * Date / Time  : 15 April 2017, 6:11 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */


@SuppressWarnings("unused") public class IntegerClass extends Class
{
    private          int                 clazz;
    @NotNull private StringTermContainer terms;
    private          double              weight;


    public IntegerClass(int clazz)
    {
        this.clazz = clazz;
        this.terms = new StringTermContainer();
    }

    public int getClazz()
    {
        return this.clazz;
    }

    public void setClazz(int clazz)
    {
        this.clazz = clazz;
    }

    public void addTerm(StringTerm stringTerm)
    {
        this.terms.add(stringTerm);
    }

    @NotNull public StringTermContainer getTermContainer()
    {
        return this.terms;
    }

    @Override public boolean equals(Object o)
    {
        if(this == o)
        {
            return true;
        }
        if(o == null || getClass() != o.getClass())
        {
            return false;
        }

        IntegerClass that = (IntegerClass) o;

        return clazz == that.clazz;
    }

    @Override public void summarizeVoting(@NotNull List<Documents> collect)
    {
        this.weight = collect.stream().mapToDouble(value -> ((Journal) value).getWeightVoting()).sum();
    }

    @Override public int hashCode()
    {
        return clazz;
    }

    @Override public int orderByWeight(@NotNull Class clazz)
    {
        return -(int) FastMath.signum(this.weight - ((IntegerClass) clazz).weight);
    }

    public double getWeight()
    {
        return this.weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    @Override public String toString()
    {
        return new ToStringBuilder(this)
                .append("clazz", clazz)
                .append("terms", terms)
                .append("weight", weight)
                .toString();
    }
}

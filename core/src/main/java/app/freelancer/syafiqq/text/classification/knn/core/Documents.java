package app.freelancer.syafiqq.text.classification.knn.core;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * This <mknn> created by : 
 * Name         : syafiq
 * Date / Time  : 15 April 2017, 4:59 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public abstract class Documents<C extends Class, B extends BagOfWords>
{
    @Nullable protected C clazz;
    @NotNull protected  B bagOfWords;

    public Documents(@Nullable C clazz, @NotNull B bagOfWords)
    {
        this.clazz = clazz;
        this.bagOfWords = bagOfWords;
    }

    @Nullable public C getClazz()
    {
        return this.clazz;
    }

    public void setClazz(@Nullable C clazz)
    {
        this.clazz = clazz;
    }

    @NotNull public B getBagOfWords()
    {
        return this.bagOfWords;
    }

    public void setBagOfWords(@NotNull B bagOfWords)
    {
        this.bagOfWords = bagOfWords;
    }

    @Override public String toString()
    {
        return new ToStringBuilder(this)
                .append("clazz", clazz)
                .append("bagOfWords", bagOfWords)
                .toString();
    }
}
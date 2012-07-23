package com.carmanconsulting.validation.facet.ognl;

import com.carmanconsulting.validation.ValidationException;
import com.carmanconsulting.validation.facet.Facet;
import com.carmanconsulting.validation.facet.FacetException;
import ognl.Ognl;
import ognl.OgnlException;

public class OgnlFacet<T> implements Facet<T>
{
    private final Object tree;

    public OgnlFacet(String expression)
    {
        try
        {
            this.tree = Ognl.parseExpression(expression);
        }
        catch (OgnlException e)
        {
            throw new FacetException("Unable to parse expression '" + expression + "'.");
        }
    }

    @Override
    public Object getValue(T bean)
    {
        try
        {
            return Ognl.getValue(tree, bean);
        }
        catch (OgnlException e)
        {
            throw new FacetException("Unable to evaluate expression '" + tree + "'.");
        }
    }

    @Override
    public void setValue(T bean, Object value)
    {
        try
        {
            Ognl.setValue(tree, bean, value);
        }
        catch (OgnlException e)
        {
            throw new FacetException("Unable to set value using expression '" + tree + "'.");
        }
    }
}

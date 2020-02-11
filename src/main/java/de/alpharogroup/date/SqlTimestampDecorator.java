/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.date;

import java.sql.Timestamp;

/**
 * The class {@link SqlTimestampDecorator} is a {@link Timestamp} decorator.
 */
public class SqlTimestampDecorator
{

	private Timestamp date;

	public static class SqlTimestampDecoratorBuilder
	{

		private Timestamp date;

		SqlTimestampDecoratorBuilder()
		{
		}

		public SqlTimestampDecoratorBuilder date(final Timestamp date)
		{
			this.date = date;
			return this;
		}

		public SqlTimestampDecorator build()
		{
			return new SqlTimestampDecorator(date);
		}

		@Override
		public String toString()
		{
			return "SqlTimestampDecorator.SqlTimestampDecoratorBuilder(date=" + this.date + ")";
		}
	}

	public static SqlTimestampDecoratorBuilder builder()
	{
		return new SqlTimestampDecoratorBuilder();
	}

	public SqlTimestampDecoratorBuilder toBuilder()
	{
		return new SqlTimestampDecoratorBuilder().date(this.date);
	}

	public Timestamp getDate()
	{
		return this.date;
	}

	public SqlTimestampDecorator setDate(final Timestamp date)
	{
		this.date = date;
		return this;
	}

	@Override
	public boolean equals(final Object o)
	{
		if (o == this)
			return true;
		if (!(o instanceof SqlTimestampDecorator))
			return false;
		final SqlTimestampDecorator other = (SqlTimestampDecorator)o;
		if (!other.canEqual((Object)this))
			return false;
		final Object this$date = this.getDate();
		final Object other$date = other.getDate();
		if (this$date == null ? other$date != null : !this$date.equals(other$date))
			return false;
		return true;
	}

	protected boolean canEqual(final Object other)
	{
		return other instanceof SqlTimestampDecorator;
	}

	@Override
	public int hashCode()
	{
		final int PRIME = 59;
		int result = 1;
		final Object $date = this.getDate();
		result = result * PRIME + ($date == null ? 43 : $date.hashCode());
		return result;
	}

	@Override
	public String toString()
	{
		return "SqlTimestampDecorator(date=" + this.getDate() + ")";
	}

	public SqlTimestampDecorator()
	{
	}

	public SqlTimestampDecorator(final Timestamp date)
	{
		this.date = date;
	}
}
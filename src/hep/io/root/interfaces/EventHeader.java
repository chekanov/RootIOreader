/*
 * Interface created by InterfaceBuilder. Do not modify.
 *
 * Created on Tue Feb 16 13:13:15 CST 2021
 */

package hep.io.root.interfaces;

public interface EventHeader extends hep.io.root.RootObject
{
	int getEvtNum();
	int getRun();
	int getDate();

	public final static int rootIOVersion=1;
}

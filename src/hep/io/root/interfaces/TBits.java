/*
 * Interface created by InterfaceBuilder. Do not modify.
 *
 * Created on Tue Feb 16 13:13:15 CST 2021
 */

package hep.io.root.interfaces;

public interface TBits extends hep.io.root.RootObject, hep.io.root.interfaces.TObject
{
	/** Highest bit set + 1 */
	int getNbits();
	/** Number of UChars in fAllBits */
	int getNbytes();
	/** [fNbytes] array of UChars */

	public final static int rootIOVersion=1;
	public final static int rootCheckSum=242629704;
}

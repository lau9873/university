/* ###
 * IP: GHIDRA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/* Generated by Together */

package ghidra.program.model.symbol;

/**
 * Class to define reference types.
 */
public abstract class RefType {

	//
	// NOTE:
	// When creating a new flow type, be sure
	// to add code to the RefTypeFactory
	//

	static final byte __INVALID = -2;

	// CODE REFERENCE TYPES
	static final byte __UNKNOWNFLOW = -1;
	static final byte __FALL_THROUGH = 0;
	static final byte __UNCONDITIONAL_JUMP = 1;
	static final byte __CONDITIONAL_JUMP = 2;
	static final byte __UNCONDITIONAL_CALL = 3;
	static final byte __CONDITIONAL_CALL = 4;
	static final byte __TERMINATOR = 5;
	static final byte __COMPUTED_JUMP = 6;
	static final byte __CONDITIONAL_TERMINATOR = 7;
	static final byte __COMPUTED_CALL = 8;

	static final byte __INDIRECTION = 9;

	static final byte __CALL_TERMINATOR = 10;
	static final byte __JUMP_TERMINATOR = 11;

	static final byte __CONDITIONAL_COMPUTED_JUMP = 12;
	static final byte __CONDITIONAL_COMPUTED_CALL = 13;

	static final byte __CONDITIONAL_CALL_TERMINATOR = 14;
	static final byte __COMPUTED_CALL_TERMINATOR = 15;

	static final byte __CALL_OVERRIDE_UNCONDITIONAL = 16;
	static final byte __JUMP_OVERRIDE_UNCONDITIONAL = 17;

	static final byte __CALLOTHER_OVERRIDE_CALL = 18;
	static final byte __CALLOTHER_OVERRIDE_JUMP = 19;

	// DATA REFERENCE TYPES
	static final byte __UNKNOWNDATA = 100;
	static final byte __READ = 101;
	static final byte __WRITE = 102;
	static final byte __READ_WRITE = 103;
	static final byte __READ_IND = 104;
	static final byte __WRITE_IND = 105;
	static final byte __READ_WRITE_IND = 106;
	static final byte __UNKNOWNPARAM = 107;
	static final byte __EXTERNAL_REF = 113;
	static final byte __UNKNOWNDATA_IND = 114;

	static final byte __DYNAMICDATA = 127;

	public static final FlowType INVALID =
		new FlowType.Builder(__INVALID, "INVALID")
				.setHasFall()
				.build();
	public static final FlowType FLOW =
		new FlowType.Builder(__UNKNOWNFLOW, "FLOW")
				.setHasFall()
				.build();
	public static final FlowType FALL_THROUGH =
		new FlowType.Builder(__FALL_THROUGH, "FALL_THROUGH")
				.setHasFall()
				.build();
	public static final FlowType UNCONDITIONAL_JUMP =
		new FlowType.Builder(__UNCONDITIONAL_JUMP, "UNCONDITIONAL_JUMP")
				.setIsJump()
				.build();
	public static final FlowType CONDITIONAL_JUMP =
		new FlowType.Builder(__CONDITIONAL_JUMP, "CONDITIONAL_JUMP")
				.setHasFall()
				.setIsJump()
				.setIsConditional()
				.build();
	public static final FlowType UNCONDITIONAL_CALL =
		new FlowType.Builder(__UNCONDITIONAL_CALL, "UNCONDITIONAL_CALL")
				.setHasFall()
				.setIsCall()
				.build();
	public static final FlowType CONDITIONAL_CALL =
		new FlowType.Builder(__CONDITIONAL_CALL, "CONDITIONAL_CALL")
				.setHasFall()
				.setIsCall()
				.setIsConditional()
				.build();
	public static final FlowType TERMINATOR =
		new FlowType.Builder(__TERMINATOR, "TERMINATOR")
				.setIsTerminal()
				.build();
	public static final FlowType COMPUTED_JUMP =
		new FlowType.Builder(__COMPUTED_JUMP, "COMPUTED_JUMP")
				.setIsJump()
				.setIsComputed()
				.build();
	public static final FlowType CONDITIONAL_TERMINATOR =
		new FlowType.Builder(__CONDITIONAL_TERMINATOR, "CONDITIONAL_TERMINATOR")
				.setHasFall()
				.setIsTerminal()
				.setIsConditional()
				.build();
	public static final FlowType COMPUTED_CALL =
		new FlowType.Builder(__COMPUTED_CALL, "COMPUTED_CALL")
				.setHasFall()
				.setIsCall()
				.setIsComputed()
				.build();
	public static final FlowType CALL_TERMINATOR =
		new FlowType.Builder(__CALL_TERMINATOR, "CALL_TERMINATOR")
				.setIsCall()
				.setIsTerminal()
				.build();
	public static final FlowType COMPUTED_CALL_TERMINATOR =
		new FlowType.Builder(__COMPUTED_CALL_TERMINATOR, "COMPUTED_CALL_TERMINATOR")
				.setIsCall()
				.setIsTerminal()
				.setIsComputed()
				.build();
	public static final FlowType CONDITIONAL_CALL_TERMINATOR =
		new FlowType.Builder(__CONDITIONAL_CALL_TERMINATOR, "CONDITIONAL_CALL_TERMINATOR")
				.setIsCall()
				.setIsTerminal()
				.setIsConditional()
				.build();
	public static final FlowType CONDITIONAL_COMPUTED_CALL = new FlowType.Builder(
		__CONDITIONAL_COMPUTED_CALL, "CONDITIONAL_COMPUTED_CALL")
				.setHasFall()
				.setIsCall()
				.setIsComputed()
				.setIsConditional()
				.build();
	public static final FlowType CONDITIONAL_COMPUTED_JUMP =
		new FlowType.Builder(__CONDITIONAL_COMPUTED_JUMP, "CONDITIONAL_COMPUTED_JUMP")
				.setHasFall()
				.setIsJump()
				.setIsComputed()
				.setIsConditional()
				.build();
	public static final FlowType JUMP_TERMINATOR =
		new FlowType.Builder(__JUMP_TERMINATOR, "JUMP_TERMINATOR")
				.setIsJump()
				.setIsTerminal()
				.build();
	public static final FlowType INDIRECTION =
		new FlowType.Builder(__INDIRECTION, "INDIRECTION")
				.build();
	public static final FlowType CALL_OVERRIDE_UNCONDITIONAL =
		new FlowType.Builder(__CALL_OVERRIDE_UNCONDITIONAL, "CALL_OVERRIDE_UNCONDITIONAL")
				.setHasFall()
				.setIsCall()
				.setIsOverride()
				.build();
	public static final FlowType JUMP_OVERRIDE_UNCONDITIONAL =
		new FlowType.Builder(__JUMP_OVERRIDE_UNCONDITIONAL, "JUMP_OVERRIDE_UNCONDITIONAL")
				.setIsJump()
				.setIsOverride()
				.build();
	public static final FlowType CALLOTHER_OVERRIDE_CALL =
		new FlowType.Builder(__CALLOTHER_OVERRIDE_CALL, "CALLOTHER_OVERRIDE_CALL")
				.setHasFall()
				.setIsCall()
				.setIsOverride()
				.build();
	public static final FlowType CALLOTHER_OVERRIDE_JUMP =
		new FlowType.Builder(__CALLOTHER_OVERRIDE_JUMP, "CALLOTHER_OVERRIDE_JUMP")
				.setIsJump()
				.setIsOverride()
				.build();

	/**
	 * Reference type is unknown.
	 */

	public static final RefType THUNK = new DataRefType(__DYNAMICDATA, "THUNK", 0);

	/**
	 * Reference type assigned when data access is unknown.
	 */
	public static final RefType DATA = new DataRefType(__UNKNOWNDATA, "DATA", 0);

	/**
	 * Reference type assigned when data (constant or pointer) is passed to a function
	 */
	public static final RefType PARAM = new DataRefType(__UNKNOWNPARAM, "PARAM", 0);

	public static final RefType DATA_IND =
		new DataRefType(__UNKNOWNDATA_IND, "DATA_IND", DataRefType.INDX);

	/**
	 * Reference type assigned when data is being read.
	 */
	public static final RefType READ = new DataRefType(__READ, "READ", DataRefType.READX);

	/**
	 * Reference type assigned when data is being written.
	 */
	public static final RefType WRITE = new DataRefType(__WRITE, "WRITE", DataRefType.WRITEX);

	/**
	 * Reference type assigned when data is read and written.
	 */
	public static final RefType READ_WRITE =
		new DataRefType(__READ_WRITE, "READ_WRITE", DataRefType.READX | DataRefType.WRITEX);

	/**
	 * Reference type assigned when data is being read.
	 */
	public static final RefType READ_IND =
		new DataRefType(__READ_IND, "READ_IND", DataRefType.READX | DataRefType.INDX);

	/**
	 * Reference type assigned when data is being written.
	 */
	public static final RefType WRITE_IND =
		new DataRefType(__WRITE_IND, "WRITE_IND", DataRefType.WRITEX | DataRefType.INDX);

	/**
	 * Reference type assigned when data is read and written.
	 */
	public static final RefType READ_WRITE_IND = new DataRefType(__READ_WRITE_IND, "READ_WRITE_IND",
		DataRefType.READX | DataRefType.WRITEX | DataRefType.INDX);

	/**
	 * Reference type used internally to identify external entry points.
	 * The use of this RefType for references to external library data or functions
	 * is deprecated and should not be used for that purpose.
	 */
	public static final RefType EXTERNAL_REF = new DataRefType(__EXTERNAL_REF, "EXTERNAL", 0);

	private byte type;
	private String name;

	protected RefType(byte type, String name) {
		this.type = type;
		this.name = name;
	}

	/**
	 * Get the int value for this RefType object
	 * @return the value
	 */
	public byte getValue() {
		return type;
	}

	/**
	 * Returns true if the reference is to data
	 * @return true if the reference is to data
	 */
	public boolean isData() {
		return false;
	}

	/**
	 * Returns true if the reference is a read
	 * @return true if the reference is a read
	 */
	public boolean isRead() {
		return false;
	}

	/**
	 * Returns true if the reference is a write
	 * @return true if the reference is a write
	 */
	public boolean isWrite() {
		return false;
	}

	/**
	 * Returns true if the reference is indirect
	 * @return true if the reference is indirect
	 */
	public boolean isIndirect() {
		if (this == INDIRECTION) {
			return true;
		}
		return false;
	}

	/**
	 * Returns true if the reference is an instruction flow reference
	 * @return true if the reference is an instruction flow reference
	 */
	public boolean isFlow() {
		return false;
	}

	/**
	 * Return true if this flow type is one that does not cause a break in control flow
	 * @return if this flow type is one that does not cause a break in control flow
	 */
	public final boolean isFallthrough() {
		return this == FALL_THROUGH;
	}

	/**
	 * Returns true if this flow type can fall through
	 * @return true if can fall through
	 */
	public boolean hasFallthrough() {
		return false;
	}

	/**
	 * Returns true if the flow is call
	 * @return true if is a call
	 */
	public boolean isCall() {
		return false;
	}

	/**
	 * Returns true if the flow is jump
	 * @return true if is a jump
	 */
	public boolean isJump() {
		return false;
	}

	/**
	 * Returns true if the flow is an unconditional call or jump
	 * @return true if unconditional
	 */
	public boolean isUnConditional() {
		return !isConditional();
	}

	/**
	 * Returns true if the flow is a conditional call or jump
	 * @return true if is conditional
	 */
	public boolean isConditional() {
		return false;
	}

	/**
	 * Returns true if the flow is a computed call or compute jump
	 * @return true if is computed
	 */
	public boolean isComputed() {
		return false;
	}

	/**
	 * Returns true if this instruction terminates
	 * @return true if terminal
	 */
	public boolean isTerminal() {
		return false;
	}

	/**
	 * True if this is an override reference
	 * @return true if this is an override reference
	 */
	public boolean isOverride() {
		return false;
	}

	/**
	 * Returns name of ref-type
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !getClass().equals(obj.getClass())) {
			return false;
		}
		RefType other = (RefType) obj;
		return type == other.type;
	}

	@Override
	public int hashCode() {
		return type;
	}

	@Override
	public String toString() {
		return name;
	}
}
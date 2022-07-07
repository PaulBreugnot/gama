// This software is released into the Public Domain. See copying.txt for details.
package msi.gama.ext.osmosis;

/**
 * A data class representing a single member within a relation entity.
 *
 * @author Brett Henderson
 */
public class RelationMember implements Comparable<RelationMember>, Storeable {

	private final long memberId;
	private final EntityType memberType;
	private final String memberRole;

	/**
	 * Creates a new instance.
	 *
	 * @param memberId
	 *            The id of the entity that this member consists of.
	 * @param memberType
	 *            The type of the entity that this member consists of.
	 * @param memberRole
	 *            The role that this member forms within the relation.
	 */
	public RelationMember(final long memberId, final EntityType memberType, final String memberRole) {
		this.memberId = memberId;
		this.memberType = memberType;
		this.memberRole = memberRole;
		if (memberType == null) { throw new IllegalArgumentException("null type given for relation-member"); }
		if (memberRole == null) { throw new IllegalArgumentException("null role given for relation-member"); }
	}

	/**
	 * Creates a new instance.
	 *
	 * @param sr
	 *            The store to read state from.
	 * @param scr
	 *            Maintains the mapping between classes and their identifiers within the store.
	 */
	public RelationMember(final StoreReader sr, final StoreClassRegister scr) {
		this(sr.readLong(), EntityType.valueOf(sr.readString()), sr.readString());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void store(final StoreWriter sw, final StoreClassRegister scr) {
		sw.writeLong(memberId);
		sw.writeString(memberType.toString());
		sw.writeString(memberRole);
	}

	/**
	 * Compares this relation member to the specified relation member. The relation member comparison is based on a
	 * comparison of member type, then member id, then role.
	 *
	 * @param relationMember
	 *            The relation member to compare to.
	 * @return 0 if equal, &lt; 0 if considered "smaller", and &gt; 0 if considered "bigger".
	 */
	@Override
	public int compareTo(final RelationMember relationMember) {
		long result;

		// Compare the member type.
		result = this.memberType.compareTo(relationMember.memberType);
		if (result > 0) {
			return 1;
		} else if (result < 0) { return -1; }

		// Compare the member id.
		result = this.memberId - relationMember.memberId;
		if (result > 0) {
			return 1;
		} else if (result < 0) { return -1; }

		// Compare the member role.
		result = this.memberRole.compareTo(relationMember.memberRole);
		if (result > 0) {
			return 1;
		} else if (result < 0) { return -1; }

		// No differences detected.
		return 0;
	}

	/**
	 * Returns the id of the member entity.
	 *
	 * @return The member id.
	 */
	public long getMemberId() {
		return memberId;
	}

	/**
	 * Returns the type of the member entity.
	 *
	 * @return The member type.
	 */
	public EntityType getMemberType() {
		return memberType;
	}

	/**
	 * Returns the role that this member forms within the relation.
	 *
	 * @return The role.
	 */
	public String getMemberRole() {
		return memberRole;
	}

	/**
	 * ${@inheritDoc}.
	 */
	@Override
	public String toString() {
		return "RelationMember(" + getMemberType() + " with id " + getMemberId() + " in the role '" + getMemberRole()
				+ "')";
	}
}

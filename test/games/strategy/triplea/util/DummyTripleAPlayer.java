/*
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package games.strategy.triplea.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import games.strategy.engine.data.PlayerID;
import games.strategy.engine.data.Resource;
import games.strategy.engine.data.Territory;
import games.strategy.engine.data.Unit;
import games.strategy.net.GUID;
import games.strategy.triplea.delegate.DiceRoll;
import games.strategy.triplea.delegate.Matches;
import games.strategy.triplea.delegate.dataObjects.CasualtyDetails;
import games.strategy.triplea.delegate.dataObjects.CasualtyList;
import games.strategy.triplea.player.ITripleaPlayer;
import games.strategy.util.IntegerMap;
import games.strategy.util.Match;
import games.strategy.util.Tuple;

public class DummyTripleAPlayer implements ITripleaPlayer {
  public void politics(final boolean firstRun) {}

  @Override
  public void confirmEnemyCasualties(final GUID battleId, final String message, final PlayerID hitPlayer) {}

  @Override
  public boolean confirmMoveHariKari() {
    return false;
  }

  @Override
  public boolean confirmMoveInFaceOfAA(final Collection<Territory> aaFiringTerritories) {
    return false;
  }

  @Override
  public boolean confirmMoveKamikaze() {
    return false;
  }

  @Override
  public void confirmOwnCasualties(final GUID battleId, final String message) {}

  @Override
  public PlayerID getPlayerID() {
    return null;
  }

  @Override
  public Collection<Unit> getNumberOfFightersToMoveToNewCarrier(final Collection<Unit> fightersThatCanBeMoved, final Territory from) {
    return null;
  }

  @Override
  public void reportError(final String error) {}

  @Override
  public void reportMessage(final String message, final String title) {}

  @Override
  public boolean acceptAction(final PlayerID playerSendingProposal, final String message, final boolean politics) {
    return true;
  }

  @Override
  public Territory retreatQuery(final GUID battleID, final boolean submerge, final Territory battleSite,
      final Collection<Territory> possibleTerritories, final String message) {
    return null;
  }


  @Override
  public HashMap<Territory, Collection<Unit>> scrambleUnitsQuery(final Territory scrambleTo,
      final Map<Territory, Tuple<Collection<Unit>, Collection<Unit>>> possibleScramblers) {
    return null;
  }

  @Override
  public boolean selectAttackSubs(final Territory unitTerritory) {
    return false;
  }

  @Override
  public boolean selectAttackTransports(final Territory unitTerritory) {
    return false;
  }

  @Override
  public boolean selectAttackUnits(final Territory unitTerritory) {
    return false;
  }

  @Override
  public Territory selectBombardingTerritory(final Unit unit, final Territory unitTerritory, final Collection<Territory> territories,
      final boolean noneAvailable) {
    return null;
  }

  @Override
  public CasualtyDetails selectCasualties(final Collection<Unit> selectFrom, final Map<Unit, Collection<Unit>> dependents, final int count,
      final String message, final DiceRoll dice,
      final PlayerID hit, final Collection<Unit> friendlyUnits, final PlayerID enemyPlayer, final Collection<Unit> enemyUnits,
      final boolean amphibious,
      final Collection<Unit> amphibiousLandAttackers, final CasualtyList defaultCasualties, final GUID battleID, final Territory battlesite,
      final boolean allowMultipleHitsPerUnit) {
    return new CasualtyDetails(defaultCasualties.getKilled(), defaultCasualties.getDamaged(), true);
  }

  @Override
  public int[] selectFixedDice(final int numDice, final int hitAt, final boolean hitOnlyIfEquals, final String title, final int diceSides) {
    return null;
  }

  @Override
  public boolean selectShoreBombard(final Territory unitTerritory) {
    return false;
  }

  @Override
  public Territory selectTerritoryForAirToLand(final Collection<Territory> candidates, final Territory currentTerritory,
      final String unitMessage) {
    return null;
  }

  @Override
  public boolean shouldBomberBomb(final Territory territory) {
    return false;
  }

  @Override
  public Unit whatShouldBomberBomb(final Territory territory, final Collection<Unit> potentialTargets, final Collection<Unit> bombers) {
    if (potentialTargets == null || potentialTargets.isEmpty()) {
      return null; // is null even allowed?
    }
    final Collection<Unit> typicalFactories = Match.getMatches(potentialTargets, Matches.UnitCanProduceUnitsAndCanBeDamaged);
    if (typicalFactories.isEmpty()) {
      return potentialTargets.iterator().next();
    }
    return typicalFactories.iterator().next();
  }

  @Override
  public Territory whereShouldRocketsAttack(final Collection<Territory> candidates, final Territory from) {
    return null;
  }

  @Override
  public Collection<Unit> selectUnitsQuery(final Territory current, final Collection<Unit> possible, final String message) {
    return null;
  }

  @Override
  public HashMap<Territory, HashMap<Unit, IntegerMap<Resource>>> selectKamikazeSuicideAttacks(
      final HashMap<Territory, Collection<Unit>> possibleUnitsToAttack) {
    return null;
  }

  @Override
  public Tuple<Territory, Set<Unit>> pickTerritoryAndUnits(final List<Territory> territoryChoices, final List<Unit> unitChoices,
      final int unitsPerPick) {
    return null;
  }
}

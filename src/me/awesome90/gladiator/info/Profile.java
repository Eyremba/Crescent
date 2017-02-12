package me.awesome90.gladiator.info;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.awesome90.gladiator.behaviour.Behaviour;
import me.awesome90.gladiator.detection.Check;
import me.awesome90.gladiator.detection.CheckType;
import me.awesome90.gladiator.detection.Detection;

public class Profile {

	private final UUID uuid;
	private final Behaviour behaviour;
	private ArrayList<Check> checks;

	private ArrayList<Detection> detections;

	public Profile(UUID uuid) {
		this.uuid = uuid;
		this.behaviour = new Behaviour(this);
		// Create an ArrayList containing all the checks. This should only be
		// able to hold the maximum size of checks.
		this.checks = new ArrayList<Check>(CheckType.values().length);
		this.detections = new ArrayList<Detection>();
	}

	public void addDetection(Detection detection) {
		detections.add(detection);
	}

	public Behaviour getBehaviour() {
		return behaviour;
	}

	public ArrayList<Detection> getDetections() {
		return detections;
	}

	public final boolean isOnline() {
		return getPlayer() != null;
	}

	public final Player getPlayer() {
		return Bukkit.getPlayer(uuid);
	}

}

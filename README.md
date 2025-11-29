## UAVGuard Sdk
---

# About

Sdk for creating plugins.

# How it works

Use the Plugin, Video, and Command classes as the core of your implementation.
The Action and Movement classes are auxiliary tools:

## Command: device control

### • int getPort()
```
Returns the destination port where the command should be sent.
This allows each plugin or functionality to use different ports (e.g. control, telemetry, video, etc.).
```

### • byte[] getPacket()

```
Returns the packet that will be sent to the device. Contains the payload (payload). It can be built from Action, Movement or additional parameters. It is the final format that will be transmitted via socket/UDP/TCP
```

### • Action[] getActions()
```
Returns a list of static actions (Action) associated with this command. Action represents ready-made (pre-assembled) packages. They are useful for simple operations like takeoff, land, stop, light on/off, etc. The plugin can use this list to reuse fixed payloads.
```

### • void setParameter(Movement action, int percent)
```
Sets a dynamic parameter based on motion.

percent is a value from -100 to 100, where:
   -100 = minimum value (e.g. maximum left / back)
    0 = neutral
    100 = maximum value (e.g. maximum right / front)

The method should adjust the command's internal package according to the desired movement.
```

#### • Movement (Enum)
```
Defines standardized abstractions that indicate which axis/movement is being configured.

Throttle / Yaw / /Pitch / Roll /
```

• Action (Class)
```
Contains static payloads used for simple actions. They are useful for accelerating the development of plugins that only need to send ready-made actions.

new Action(String name, byte[] packet) {
    this.name = "Land...";
    this.packet = new byte[n...] { n... };
}
```

## Build & Run

```
mvn clean install
```

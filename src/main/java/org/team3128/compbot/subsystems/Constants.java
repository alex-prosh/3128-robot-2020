package org.team3128.compbot.subsystems;

import org.team3128.common.utility.units.Length;
import org.team3128.common.utility.units.Angle;
import org.team3128.common.utility.test_suite.*;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import org.team3128.common.generics.RobotConstants;

// the superclass is purely for semantic purposes
public class Constants extends RobotConstants {

        // MECHANISM CONSTANTS:
        public static final double ENCODER_RESOLUTION_PER_ROTATION = 2048;
        public static final double inchesToMeters = 0.0254;
        public static final double DT = 0.005; // time between update() method calls for mechanisms

        // ---- DRIVE
        public static final double kDriveInchesPerSecPerNUp100ms = (1000d / 1) * (1 / ENCODER_RESOLUTION_PER_ROTATION)
                        * (Constants.WHEEL_DIAMETER * Math.PI) * Constants.WHEEL_ROTATIONS_FOR_ONE_ENCODER_ROTATION;
        // a fairly basic relationship between tangential and
        // rotational speed: NU/100ms * 1000ms/1second * 1/(encoder resolution) *
        // CIRCUM *
        // (relation between encoder rotations and wheel
        // rotations) = in/s
        public static final double kDriveNuToInches = (1 / Constants.ENCODER_RESOLUTION_PER_ROTATION)
                        * Constants.WHEEL_DIAMETER * Math.PI * Constants.WHEEL_ROTATIONS_FOR_ONE_ENCODER_ROTATION;

        public static final NeutralMode DRIVE_IDLE_MODE = NeutralMode.Coast;

        public static final double ENCODER_ROTATIONS_FOR_ONE_WHEEL_ROTATION = 72 / 8; // basically your gearing. Ask
                                                                                      // Mech
                                                                                      // for gear teeth number to gear
                                                                                      // teeth number ratio: 8.3333333

        public static final double WHEEL_ROTATIONS_FOR_ONE_ENCODER_ROTATION = 1
                        / Constants.ENCODER_ROTATIONS_FOR_ONE_WHEEL_ROTATION;

        public static final int RIGHT_DRIVE_FRONT_ID = 0;
        public static final int RIGHT_DRIVE_MIDDLE_ID = 1;
        // public static final int RIGHT_DRIVE_BACK_ID = 0;

        public static final int LEFT_DRIVE_FRONT_ID = 2;
        public static final int LEFT_DRIVE_MIDDLE_ID = 3;
        // public static final int LEFT_DRIVE_BACK_ID = 3;

        public static final int DRIVE_HIGH_SPEED = 140; // Empirical Max Linear Speed: TBD in/s

        public static final double WHEEL_DIAMETER = 3.55; // effective wheel diameter (measure first then tune this
                                                          // number until distances are accurate)

        public static final double LEFT_SPEEDSCALAR = 1.0; // purely for TELEOP drive (to make sure that when the drive
                                                           // pushes the joystick forward, both sides of the drivetrain
                                                           // are
                                                           // going ROUGHLY the same speed)
        public static final double RIGHT_SPEEDSCALAR = 1.0;// purely for TELEOP drive (to make sure that when the drive
                                                           // pushes the joystick forward, both sides of the drivetrain
                                                           // are
                                                           // going ROUGHLY the same speed)

        public static final double DRIVE_ACCEL_LIMIT = 120; // Ballpark estimates from mech (Be conservative unless you
                                                            // really need the quick auto paths)
        public static final double DRIVE_JERK_LIMIT = 2000; // Ballpark estimates (Be conservative)

        public static double K_AUTO_RIGHT_P = 0.00007; // 0.00065
        public static double K_AUTO_RIGHT_D = 0.000;
        public static double K_AUTO_RIGHT_F = 1 / 145.9150145782 * kDriveInchesPerSecPerNUp100ms; // 1/ (consistent max
                                                                                                  // vel
                                                                                                  // of this side of
                                                                                                  // drivetrain in/s) *
                                                                                                  // conversion to NU/s
        public static double K_AUTO_LEFT_P = 0.00007;
        public static double K_AUTO_LEFT_D = 0.000; // 0.0001
        public static double K_AUTO_LEFT_F = 1 / 140.8705712261 * kDriveInchesPerSecPerNUp100ms; // 1/ (consistent max
                                                                                                 // vel
                                                                                                 // of
                                                                                                 // this side of
                                                                                                 // drivetrain
                                                                                                 // in/s) * conversion
                                                                                                 // to
                                                                                                 // NU/s

        public static final double K_HOLD_P = 4;

        // ---- AUTONOMOUS DRIVE
        public static final double TRACK_RADIUS = 24;
        public static final double MIN_TURNING_RADIUS = 40;
        public static final double MIN_PATH_SPEED = 20;
        public static final double MAX_PATH_SPEED = 120;
        public static final double MIN_LOOKAHEAD_DISTANCE = 14;
        public static final double MAX_LOOKAHEAD_DISTANCE = 30;

        public static final double MAX_TURN_ERROR = 2;
        public static final double MAX_PID_STOP_SPEED = 8;

        // ---- LIMELIGHT
        public static final double BOTTOM_LIMELIGHT_HEIGHT = 6.15 * Length.in;
        public static final double BOTTOM_LIMELIGHT_ANGLE = 26.0 * Angle.DEGREES;
        public static final double BOTTOM_LIMELIGHT_DISTANCE_FROM_FRONT = 0 * Length.in;

        // ---- AUTO TEST SUITE
        public static CanDevices leftDriveLeader;
        public static CanDevices leftDriveFollower;
        public static CanDevices rightDriveLeader;
        public static CanDevices rightDriveFollower;
        public static CanDevices PDP;

        // ---- SHOOTER
        public static final int SHOOTER_MOTOR_LEFT_ID = 5;
        public static final int SHOOTER_MOTOR_RIGHT_ID = 11;
        public static final int SHOOTER_MOTOR_1_ID = 0;
        public static final double kP_SHOOTER = 0;
        public static final double kI_SHOOTER = 0;
        public static final double kD_SHOOTER = 0;
        public static final double SHOOTER_SATURATION_LIMIT = 1; // set limit on integral accumulation (in this case, 1
                                                                 // volt)

        // ---- HOPPER
        public static final int ALIGN_MOTOR_ID = 0;
        public static final int HOPPER_FEEDER_MOTOR_ID = 0;
        public static final int CORNER_MOTOR_ID = 0;
        public static final int SHOOTER_FEEDER_MOTOR_ID = 0;

        public static final int SENSOR_1_ID = 0;
        public static final int SENSOR_2_ID = 0;
        public static final int SENSOR_3_ID = 0;
        public static final int SENSOR_4_ID = 0;

        // ---- INTAKE
        public static final int INTAKE_MOTOR_ID = 0;
        public static final double INTAKE_MOTOR_ON_VALUE = 0.5;
        public static final double INTAKE_MOTOR_OFF_VALUE = -0.2;

        // ---- ARM
        public static final int ARM_MOTOR_LEADER_ID = 0;
        public static final int ARM_MOTOR_FOLLOWER_ID = 0;
        public static final int ARM_LIMIT_SWITCH_ID = 0;
        public static final NeutralMode ARM_NEUTRAL_MODE = NeutralMode.Coast;
        public static final double ARM_GEARING = 60 / 12 * 80 / 18 * 64 / 8; // for every (ARM_GEARING) rotations of the
                                                                             // motor, we get 1 rotation of the arm (ask
                                                                             // mech for this)
        public static final double kP_ARM = 0;
        public static final double kI_ARM = 0;
        public static final double kD_ARM = 0;
        public static final double ARM_SATURATION_LIMIT = 2 / kI_ARM; // set limit on integral accumulation
        public static final double ZEROING_POWER = -0.2;

}

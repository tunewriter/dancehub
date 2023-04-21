export interface DanceClass {
  instructor: Instructor
  location: Location
  dance_school: DanceSchool
  dance_class_name: string
  weekday: string
  start_time: Date
  end_time: Date
  dance_style: string
  room_name: string
}

export interface Instructor {
  first_name: string
  last_name: string
  biography: string
}

export interface Location {
  canton: string
  zip_code: string
  city: string
  street: string
  name: string
  note: string
}

export interface DanceSchool {
  location: Location
  dance_school_name: string
  phone_number: string
  email: string
  website: string
}
